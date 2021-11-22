package com.rs.expensetracker.exception;

import com.rs.expensetracker.enums.LoginError;
import lombok.Getter;

@Getter
public class LoginException extends RuntimeException {

    private LoginError loginError;

    public LoginException(LoginError loginError, String message) {
        super(message);
        this.loginError = loginError;
    }
}
