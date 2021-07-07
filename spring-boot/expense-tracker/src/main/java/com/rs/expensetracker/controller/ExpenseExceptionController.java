package com.rs.expensetracker.controller;

import com.rs.expensetracker.exception.ExpenseNotFoundException;
import com.rs.expensetracker.exception.FileParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpenseExceptionController {

    @ExceptionHandler(value = ExpenseNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(ExpenseNotFoundException exception) {
        return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<Object> handleInvalidId(NumberFormatException exception) {
        return new ResponseEntity<>("Invalid expense id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = FileParseException.class)
    public ResponseEntity<?> handleUploadingErrors(FileParseException fileParseException) {
        //return ResponseEntity.unprocessableEntity().build();
        return new ResponseEntity<>(fileParseException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
