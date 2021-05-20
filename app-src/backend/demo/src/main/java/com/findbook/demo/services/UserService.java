package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.entities.User;
import com.findbook.demo.exception.EmailExistsException;
import com.findbook.demo.exception.EmailNotValid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";


    //Interface UserDetailsService --> with this with can find users when we trying to login
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null)
            return user;
        else
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
    }

    //Send Link to confirm user
    public String signUpUser(User user) {
        boolean userExist = userRepository.findByEmail(user.getEmail()) == null; //Exists

        return "";
    }

    //Login user


    //GetCurrent user


    //List of users
}
