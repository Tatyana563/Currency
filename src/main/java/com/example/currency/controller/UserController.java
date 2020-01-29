
package com.example.currency.controller;

import com.example.currency.model.User;
import com.example.currency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

//http://localhost:8080/currency/registration/new
@Controller
public class UserController {

    @Autowired
    private UserService userService;
//If the user is logged in  - return user's name on page currency rates
   /* @RequestMapping(value = "/")
    public String mainPage(Model model) {
        Object secur = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (secur instanceof String) {
            model.addAttribute("logged", new org.springframework.security.core.userdetails.User(secur.toString(), "", Collections.emptyList()));
        } else {
            model.addAttribute("logged", secur);
        }
       return "currency rates";
    }*/

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registration2/new", method = RequestMethod.POST)
    public String create(
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
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setPhone(phone);
        userService.save(user);
        return "/login";
    }
}

