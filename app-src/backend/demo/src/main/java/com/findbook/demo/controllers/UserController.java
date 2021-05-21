package com.findbook.demo.controllers;


import com.findbook.demo.entities.User;
import com.findbook.demo.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    RegistrationService registrationService;

    // RequestBody transform an Httprequest into java object
    //@ResponseBody --> retunr json automaticamente
/*
    @PostMapping("/sign-up")
    public ResponseEntity registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null || userRepository.findOneByUsername(user.getUsername()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);//The user exists 409
        } else {
            //userService.register(user);
            return new ResponseEntity(HttpStatus.CREATED);
        }
            registrationService.register(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }*/


    @PostMapping("/sign-up")
    public String registerUser(@RequestBody User user) {

        return registrationService.register(user);
    }


    @GetMapping(path = "/sign-up/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


    /*    @GetMapping("/sign-in")
        public String loginUser(@RequestBody User user) {

            return "";
        }*/
/*
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String login() {

        return "/sign-in";
    }
*/


}
