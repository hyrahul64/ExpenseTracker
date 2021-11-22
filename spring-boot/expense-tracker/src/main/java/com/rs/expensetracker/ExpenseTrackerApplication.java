package com.rs.expensetracker;

//import com.rs.expensetracker.model.User;
//import com.rs.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ExpenseTrackerApplication implements CommandLineRunner {

	/*@Autowired
	private UserService userService;*/

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//userService.saveUser(new User("user", "user", true));
	}
}
