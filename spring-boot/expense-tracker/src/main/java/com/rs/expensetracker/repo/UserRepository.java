package com.rs.expensetracker.repo;

import com.rs.expensetracker.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
