package com.rs.expensetracker.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.security.core.GrantedAuthority;

//@Entity
public enum UserAuthority implements GrantedAuthority {

    USER("USER"), MANAGER("MANAGER"), ADMIN("ADMIN");

    /*@Id
    @GeneratedValue
    private Integer id;*/

    private String userAuthority;

    /*@ManyToOne
    private User user;*/


    UserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }

    @JsonCreator
    public static UserAuthority fromValue(String role) {
        switch (role) {
            case "USER":
                return USER;
            case "MANAGER":
                return MANAGER;
            case "ADMIN":
                return ADMIN;
            default:
                throw new RuntimeException("Not valid role");
        }
    }

    @Override
    public String getAuthority() {
        return userAuthority;
    }
}
