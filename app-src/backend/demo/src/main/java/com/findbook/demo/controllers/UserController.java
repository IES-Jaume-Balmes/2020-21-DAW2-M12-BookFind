package com.findbook.demo.controllers;


import com.findbook.demo.entities.User;
import com.findbook.demo.services.RegistrationService;
import com.findbook.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserService userService;

    //TODO: GENERATE CFR TOKEN AUTHENTICATION
    @PostMapping("/sign-up")
    public String registerUser(@RequestBody User user) {

        return registrationService.register(user);
    }


    @GetMapping(path = "/sign-up/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    //Modify an user
    @PutMapping("/update-user")
    public ResponseEntity<User> update(@RequestBody User user, Principal principal) {
        try {
            if (!principal.getName().equals(user.getEmail()))
                throw new UsernameNotFoundException("The email does not exists");
            return ResponseEntity.ok(userService.update(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //Get profile information
    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getProfileInfo(@PathVariable("email") String email, Principal principal) {
        if (principal.getName().equals(email)) {
            return ResponseEntity.ok(userService.findOne(email));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    //Delete the own username
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<User> deleteAcount(@PathVariable("email") String email, Principal principal) {
        // userService.ge
        if (principal.getName().equals(email)) {
            User delete = userService.findOne(email);
            userService.deleteUser(delete);
            if (userService.findOne(email) == null)
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
