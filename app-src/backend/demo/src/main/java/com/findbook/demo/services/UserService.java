package com.findbook.demo.services;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.enums.Rol;
import com.findbook.demo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
/*    @Autowired
    private PasswordEncoder passwordEncoder;*/

    public void signUpUser(User user) {


        /*Encrypt the password*/
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        Cart userCart = new Cart();
        userCart.setUser(user);
        user.setCart(userCart);
        user.setRol(Rol.USER);
        userRepository.save(user);
    }

    /**
     * Interface UserDetailsService --> with this with can find users when we trying to login
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        //return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(""));
        if (user != null)
            return user;
        else
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
    }


    //Login user


    //GetCurrent user


    //List of users
}
