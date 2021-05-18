package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.ConfirmationToken;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.stereotype.Service;


@Service
public class UserService   {

    @Autowired
    private UserRepository userRepository;

/*    @Autowired
    private PasswordEncoder passwordEncoder;*/

    public void signUpUser(User user) {


        /*Encrypt the password*/
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setPassword(user.getPassword());

        Cart userCart = new Cart();

        userCart.setUser(user);
        user.setCart(userCart);
        user.setRol(Rol.ROLE_USER);



        userRepository.save(user);


    }


    //Login user


    //GetCurrent user


    //List of users
}
