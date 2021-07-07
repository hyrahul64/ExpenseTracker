package com.rs.expensetracker.service;

import com.rs.expensetracker.exception.FileParseException;
import com.rs.expensetracker.model.Expense;
import com.rs.expensetracker.model.ExpenseType;
import com.rs.expensetracker.repo.ExpenseRepository;
import com.rs.expensetracker.repo.ExpenseTypeRepository;
import com.rs.expensetracker.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class StorageServiceImpl implements StorageService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Override
    public Integer persistRecords(MultipartFile expenseFile) {
        String line;
        Integer parsedRecords = 0;
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(expenseFile.getInputStream()));) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] fields = line.split("\\|");
                Expense expense = new Expense(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3]);
                expenseRepository.save(expense);
                if (fields.length == 5) {
                    String[] subFields = fields[4].split(",");
                    for (int i = 0; i < subFields.length; i++) {
                        String[] keyValues = subFields[i].split("=");
                        ExpenseType expenseType = new ExpenseType(expense, keyValues[0], keyValues[1]);
                        expenseTypeRepository.save(expenseType);
                    }
                }
                parsedRecords++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error in reading uploaded file.");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new FileParseException("Invalid entry in uploaded file at line:" + parsedRecords + 1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new FileParseException("Integer value not parsed in uploaded file at line:" + parsedRecords + 1);
        }
        return parsedRecords;
    }
}
