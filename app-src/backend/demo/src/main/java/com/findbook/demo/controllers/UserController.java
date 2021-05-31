package com.findbook.demo.controllers;


import com.findbook.demo.dto.UserLoginDto;
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

    /*    @PostMapping("/login")
        public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
            // throws Exception if authentication failed

            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generate(authentication);
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                User user = userService.findOne(userDetails.getUsername());
                return ResponseEntity.ok(new JwtResponse(jwt, user.getEmail(), user.getName(), user.getRole()));
            } catch (AuthenticationException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
    *//*more for test
    In a traditional MVC Spring Boot application, Spring Security would check the SecurityContextHolder for the authentication information. If not found, then you would be redirected to a login page.

For a REST API endpoint, you would not have a typical login form sent from the server. You would collect the credentials from a form on the client (AngularJS, ReactJS, VueJs, iOS app, etc) and POST the credentials to an endpoint to retrieve user information. For example, the following authenticates the user, then returns the authenticated user information to the client.

private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUser(@AuthenticationPrincipal DmsUserDetails dmsUser) {

        logger.info("User " + dmsUser.getFirstName() + " " + dmsUser.getLastName() + " logged in.");

        UserResponse user = new UserResponse();
        user.setUserId(dmsUser.getUserId());
        user.setFirstName(dmsUser.getFirstName());
        user.setLastName(dmsUser.getLastName());
        user.setEmail(dmsUser.getUsername());

        return ResponseEntity.ok(user);
    }*/
    @GetMapping("/login")
    public String userLogin() {

        return "login";
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
        if (principal.getName().equals(email)) {
            User delete = userService.findOne(email);
            userService.deleteUser(delete);
            if (userService.findOne(email) == null)
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
