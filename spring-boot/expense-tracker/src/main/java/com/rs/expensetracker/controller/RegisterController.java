package com.rs.expensetracker.controller;

import com.rs.expensetracker.exception.UserRegistrationException;
import com.rs.expensetracker.model.User;
import com.rs.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.rs.expensetracker.enums.UserRegistrationError.CONFIRM_PASSWORD;
import static com.rs.expensetracker.enums.UserRegistrationError.USER_EXIST;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("POST:register-->" + user.toString());
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            throw new UserRegistrationException(CONFIRM_PASSWORD, "Password and Confirm password are not matching.");
        }
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        if(userDetails!= null && userDetails.getUsername().equals(user.getUsername())) {
            throw new UserRegistrationException(USER_EXIST, "User already exist!");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
}
