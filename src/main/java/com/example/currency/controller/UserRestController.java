package com.example.currency.controller;

import com.example.currency.model.User;
import com.example.currency.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/currency/registration/new
@RestController
@RequestMapping("/registration")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public User create(
            //TIPS:
            // @RequestParam=input name in html
            //@PostMapping("/new") /new->th:action="@{/new}"
            @RequestParam("login") String name,
            @RequestParam("password") String password,
            @RequestParam("phonenumber") String phone,
            @RequestParam("email") String email
    ) {
        final User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userService.save(user);
        return user;
    }
}
