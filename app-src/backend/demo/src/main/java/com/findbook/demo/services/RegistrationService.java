package com.findbook.demo.services;

import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.User;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.exception.EmailNotValid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final UserService userService;

    public String register(User user) throws EmailNotValid {

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
