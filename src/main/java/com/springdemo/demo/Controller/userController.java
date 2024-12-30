package com.springdemo.demo.Controller;

import javax.swing.text.PasswordView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.demo.Model.User;
import com.springdemo.demo.Repository.UserRepository;


@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private com.springdemo.demo.Service.passwordService passwordService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        // Generate password based on first name, middle name, and last name
        String password = (passwordService).generatePassword(user.getFirstName(), user.getMiddleName(), user.getLastName());
        user.setPassword(password);

        // Save user to the database
        return userRepository.save(user);
    }
}
