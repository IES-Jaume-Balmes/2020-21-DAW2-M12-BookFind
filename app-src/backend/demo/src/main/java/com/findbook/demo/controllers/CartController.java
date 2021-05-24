package com.findbook.demo.controllers;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;*/
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserRepository userService;

    /*   @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")*/
    @RequestMapping
    public String getCart(User activeUser) {
        User customer = userService.findOneByUsername(activeUser.getUsername());
        long cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable String cartId) {
        /*    model.addAttribute("cartId", cartId);*/
        return cartId;
    }

}
