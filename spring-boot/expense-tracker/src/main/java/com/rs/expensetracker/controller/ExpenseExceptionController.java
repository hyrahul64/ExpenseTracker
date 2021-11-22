package com.rs.expensetracker.controller;

import com.rs.expensetracker.exception.ExpenseNotFoundException;
import com.rs.expensetracker.exception.FileParseException;
import com.rs.expensetracker.exception.LoginException;
import com.rs.expensetracker.exception.UserRegistrationException;
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
        return new ResponseEntity<>(fileParseException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserRegistrationException.class)
    public ResponseEntity<String> handleRegistrationErrors(UserRegistrationException userRegistrationException) {
        switch(userRegistrationException.getError()) {
            case CONFIRM_PASSWORD:
                return new ResponseEntity<>(userRegistrationException.getMessage(), HttpStatus.BAD_REQUEST);
            case USER_EXIST:
                return new ResponseEntity<>(userRegistrationException.getMessage(), HttpStatus.CONFLICT);
            default:
                return new ResponseEntity<>("Unknown user registration error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ExceptionHandler(value = LoginException.class)
    public ResponseEntity<String> handleLoginErrors(LoginException loginException) {
        switch(loginException.getLoginError()) {
            case INVALID_USER:
            case INVALID_PASSWORD:
                return new ResponseEntity<>(loginException.getMessage(), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity<>("Unknown user registration error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
