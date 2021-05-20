package com.findbook.demo.services;

import com.findbook.demo.entities.User;
import com.findbook.demo.exception.EmailNotValid;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    @Autowired
    private final UserService userService;

    @SneakyThrows
    public String register(User user) {

        boolean isValidEmail = emailValidator.test(user.getEmail());
        if (!isValidEmail) {
            throw new EmailNotValid();
        }

/*
        user.setPassword(user.getPassword());
        Cart userCart = new Cart();
        userCart.setUser(user);
        user.setCart(userCart);
        user.setRol(Rol.USER);
        userRepository.save(user);
*/

        return userService.signUpUser(
                new User(user.getFirstName(),
                        user.getLastName(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getRol())
        );
    }
}
