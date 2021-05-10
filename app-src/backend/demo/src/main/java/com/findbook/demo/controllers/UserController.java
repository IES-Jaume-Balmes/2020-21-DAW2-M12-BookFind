package com.findbook.demo.controllers;


import com.findbook.demo.entities.User;
import com.findbook.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // RequestBody transform an Httprequest into java object
    @PostMapping("/register")
    @ResponseBody
    public Long registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    //Login
/*    @PostMapping("user")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();
        user.setUser(username);
        user.setToken(token);
        return user;

    }*/
/*    @GetMapping("/list")
    public String listOfUser() {
        return "";
    }*/
}
