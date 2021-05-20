package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.entities.User;
import com.findbook.demo.exception.EmailExistsException;
import com.findbook.demo.exception.EmailNotValid;
import com.findbook.demo.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

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
    @SneakyThrows
    public String signUpUser(User user) {
        boolean userExist = userRepository.findByEmail(user.getEmail()) != null; //Exists
        if (userExist) {
            throw new EmailExistsException();
        }
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());

        Cart userCart = new Cart();
        userCart.setUser(user);
        user.setCart(userCart);
        user.setRol(Rol.USER);
        user.setPassword(encodePassword);
        userRepository.save(user);

        /*Save token*/
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //TODO: SEND EMAIL
        return token;
    }

    //Login user


    //GetCurrent user


    //List of users
}
