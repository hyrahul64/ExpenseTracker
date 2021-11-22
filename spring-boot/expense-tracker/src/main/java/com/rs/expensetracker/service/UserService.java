package com.rs.expensetracker.service;

import com.rs.expensetracker.model.User;
import com.rs.expensetracker.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        /*if(userDetails == null) {
            throw new UsernameNotFoundException(username + " not found:");
        } else {*/
            return userDetails;
        //}
    }

    public boolean validUser(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        if(userDetails.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
