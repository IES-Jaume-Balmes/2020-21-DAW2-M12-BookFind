package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Long registerUser(User user) {


        /*Encrypt the password*/
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setPassword(user.getPassword());
        userRepository.save(user);

        //Set the user role
        user.setRol(Rol.ROLE_USER);

        return user.getUserId();
    }

    //Login user


    //GetCurrent user


    //List of users
}
