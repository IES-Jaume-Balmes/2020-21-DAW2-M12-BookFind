package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.ConfirmationToken;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ConfirmationTokenService confirmationTokenService;
    @Autowired
    EmailSenderService emailSenderService;
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

        final ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);


        userRepository.save(user);


    }

    void sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/sign-up/confirm?token="
                        + token);

        emailSenderService.sendEmail(mailMessage);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    //Login user


    //GetCurrent user


    //List of users
}
