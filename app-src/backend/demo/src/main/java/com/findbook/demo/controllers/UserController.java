package com.findbook.demo.controllers;


import com.findbook.demo.entities.User;
import com.findbook.demo.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    RegistrationService registrationService;

 /*  return new ResponseEntity(HttpStatus.CONFLICT);//The user exists 409
                 return new ResponseEntity(HttpStatus.CREATED);*/


    @PostMapping("/sign-up")
    public String registerUser(@RequestBody User user) {

        return registrationService.register(user);
    }


    @GetMapping(path = "/sign-up/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


}
