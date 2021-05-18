package com.findbook.demo.services;

import com.findbook.demo.dao.ConfirmationTokenRepository;
import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.ConfirmationToken;
import com.findbook.demo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor/*@AllArgsConstructor generates a constructor with 1 parameter for each field in your class*/
public class ConfirmationTokenService {
    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    UserRepository userRepository;


    void saveConfirmationToken(ConfirmationToken confirmationToken) {

        confirmationTokenRepository.save(confirmationToken);
    }

    void deleteConfirmationToken(Long id) {

        confirmationTokenRepository.deleteById(id);
    }


    void confirmUser(ConfirmationToken confirmationToken) {

        final User user = confirmationToken.getUser();

        user.setActive(true);

        userRepository.save(user); //Update

        deleteConfirmationToken(confirmationToken.getId());

    }
}
