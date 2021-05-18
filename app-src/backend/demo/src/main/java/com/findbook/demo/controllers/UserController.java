package com.findbook.demo.controllers;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.User;
import com.findbook.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    // RequestBody transform an Httprequest into java object
    //@ResponseBody --> retunr json automaticamente
    @PostMapping("/register")

    public ResponseEntity registerUser(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()) != null || userRepository.findOneByUsername(user.getUsername()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);//The user exists 409
        } else {
            userService.signUpUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }


    //Login

}
