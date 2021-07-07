package com.rs.expensetracker.controller;

import com.rs.expensetracker.exception.FileParseException;
import com.rs.expensetracker.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    StorageService storageService;

    @PostMapping
    public String handleUpload(@RequestParam("filename") MultipartFile expenseFile) {
        System.out.println("UploadController.handleUpload");
        storageService.persistRecords(expenseFile);
        return "redirect:/";
    }

}
