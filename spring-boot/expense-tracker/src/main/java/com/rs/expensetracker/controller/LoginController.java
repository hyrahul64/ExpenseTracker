package com.rs.expensetracker.controller;

import com.rs.expensetracker.dto.LoginRequest;
import com.rs.expensetracker.exception.LoginException;
import com.rs.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.rs.expensetracker.enums.LoginError.INVALID_PASSWORD;
import static com.rs.expensetracker.enums.LoginError.INVALID_USER;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public void login(HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("LoginController.login");
        httpServletRequest.getRequestDispatcher("login.html")
                .forward(httpServletRequest, httpServletResponse);
    }

    @PostMapping(value = "/handleLogin")
    public ResponseEntity<Void> handleLogin(@RequestBody LoginRequest loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getUsername());
        if(user == null) {
            throw new LoginException(INVALID_USER, "User not found.");
        }
        if(!user.getPassword().equals(loginRequest.getPassword())) {
            throw new LoginException(INVALID_PASSWORD, "Password doesn't match.");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
