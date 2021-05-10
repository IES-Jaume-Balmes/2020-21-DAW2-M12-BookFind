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
    @RequestMapping("/register")
    @ResponseBody
    public Long registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/list")
    public String listOfUser() {
        return "";
    }
}
