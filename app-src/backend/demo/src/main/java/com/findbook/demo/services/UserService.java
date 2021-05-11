package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long registerUser(User user) {
        /*   user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));*/
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return user.getUserId();
    }

    //Login user


    //GetCurrent user

    //List of users
}
