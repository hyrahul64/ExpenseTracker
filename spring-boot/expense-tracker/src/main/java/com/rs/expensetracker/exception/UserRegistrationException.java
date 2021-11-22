package com.rs.expensetracker.exception;

import com.rs.expensetracker.enums.UserRegistrationError;

public class UserRegistrationException extends RuntimeException{


    private UserRegistrationError error;

    public UserRegistrationException(UserRegistrationError error, String message) {
        super( message);
        this.error = error;
    }

    public UserRegistrationError getError() {
        return error;
    }

    public void setError(UserRegistrationError error) {
        this.error = error;
    }
}
