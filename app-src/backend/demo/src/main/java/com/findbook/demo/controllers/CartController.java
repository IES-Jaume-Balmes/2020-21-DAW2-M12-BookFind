package com.findbook.demo.controllers;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.LineItems;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;*/
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserRepository userService;

    @GetMapping("/")
    public boolean getCartItems() {
        return true;
    }

    @PostMapping("/add")
    public boolean addToCart(@RequestBody LineItems lineItem, Principal principal) {
        return true;
    }

    @DeleteMapping("/delete/{cartItemId}")
    public boolean delateCartItems() {
        return true;
    }

    @PostMapping("/update/{cartItemId}")
    public boolean updateCartItem() {
        return true;
    }



    /*   @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")*/
/*    @RequestMapping
    public String getCart(User activeUser) {
        User customer = userService.findOneByUsername(activeUser.getUsername());
        long cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable String cartId) {
        *//*    model.addAttribute("cartId", cartId);*//*
        return cartId;
    }*/
}
