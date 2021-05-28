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

    //TODO: GENERATE CFR TOKEN AUTHENTICATION
    @PostMapping("/sign-up")
    public String registerUser(@RequestBody User user) {

        return registrationService.register(user);
    }


    @GetMapping(path = "/sign-up/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    //TODO: Modificar un usuario
/*    @PutMapping("/profile")
    public ResponseEntity<User> update(@RequestBody User user, Principal principal) {

        try {
            if (!principal.getName().equals(user.getEmail())) throw new IllegalArgumentException();
            return ResponseEntity.ok(userService.update(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }*/
}
