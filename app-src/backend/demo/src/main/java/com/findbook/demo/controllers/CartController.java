package com.findbook.demo.controllers;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Book;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.LineItems;
import com.findbook.demo.entities.User;
import com.findbook.demo.form.ItemForm;
import com.findbook.demo.services.BooksService;
import com.findbook.demo.services.CartService;
import com.findbook.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserService userService;
    @Autowired
    private BooksService booksService; //Get info about the product
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public boolean getCartItems() {
        return true;
    }


    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<LineItems> lineItems, Principal principal) {
        User user = userService.findOne(principal.getName()); //Find user by email

        try {
            cartService.mergeLocalCart(lineItems, user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Merge Cart Failed");
        }
        return ResponseEntity.ok(cartService.getCart(user)); //Retorna el carrito actualizado
    }


    /**
     * @param itemIdAndQuantity cantidad de producto y productId
     * @param principal         Spring Security Actual logued user
     * @return
     */
    @PostMapping("/add")
    public String addToCart(@RequestBody ItemForm itemIdAndQuantity, Principal principal) {

        Book bookInfo = booksService.findOne(itemIdAndQuantity.getProductId());
        try {
            //NO podemos modificar el collections singleltone, immutable
            mergeCart(Collections.singleton(new LineItems(bookInfo, itemIdAndQuantity.getQuantity())), principal);
        } catch (Exception e) {
            return e.toString();
        }
        return principal.getName();
    }

/*
    @DeleteMapping("/delete/{cartItemId}")
    public boolean delateCartItems() {
        return true;
    }

    @PostMapping("/update/{cartItemId}")
    public boolean updateCartItem() {
        return true;
    }


    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")

    @RequestMapping
    public String getCart(User activeUser) {
        User customer = userService.findOneByUsername(activeUser.getUsername());
        long cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable String cartId) {

        model.addAttribute("cartId", cartId);
        return cartId;
    }
*/

}
