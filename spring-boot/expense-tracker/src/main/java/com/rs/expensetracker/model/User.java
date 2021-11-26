package com.rs.expensetracker.model;

import com.rs.expensetracker.enums.UserAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;
    private String password;
    @Transient
    private String confirmPassword;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private UserAuthority userAuthority;

    //NOTE: Following not working without @OneToMany annotation. Why hibernate doesn't allow uni-direction relation here?
    //As other side is ENUM so?
    //Also see this: https://stackoverflow.com/questions/416208/jpa-map-collection-of-enums
    /*@OneToMany(mappedBy = "user")
    private Set<UserAuthority> authorities = new HashSet<>();*/


    public User() {
    }

    /*public User(String username, String password, Set<UserAuthority> authorities) {
        this.username = username;
        this.password = password;
        //this.authorities = authorities;
    }*/


    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(userAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserAuthority getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(UserAuthority userAuthority) {
        this.userAuthority = userAuthority;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", userAuthority=" + userAuthority +
             //   ", authorities=" + authorities +
                '}';
    }
}
