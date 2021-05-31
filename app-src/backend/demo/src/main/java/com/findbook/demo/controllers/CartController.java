package com.findbook.demo.controllers;

import com.findbook.demo.entities.*;
import com.findbook.demo.dto.ItemForm;
import com.findbook.demo.exception.CartItemsException;
import com.findbook.demo.exception.IsbnException;
import com.findbook.demo.services.BooksService;
import com.findbook.demo.services.CartService;
import com.findbook.demo.services.LineItemService;
import com.findbook.demo.services.UserService;
import lombok.SneakyThrows;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserService userService;
    @Autowired
    private BooksService booksService;
    @Autowired
    private CartService cartService;
    @Autowired
    private LineItemService lineItemService;

    /**
     * @param principal the logged in user
     * @return all items and info of the logged in user cart
     */
    @GetMapping("")
    public Cart getCart(Principal principal) {
        User user = userService.findOne(principal.getName());
        return cartService.getCart(user);
    }

    /**
     * @param lineItems all items to buy
     * @param principal the logged in user
     * @return cart with new items
     */
    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<LineItems> lineItems, Principal principal) {
        User user = userService.findOne(principal.getName()); //Find user by email
        try {
            cartService.mergeLocalCart(lineItems, user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Merge Cart Failed");
        }
        return ResponseEntity.ok(cartService.getCart(user));
    }


    /**
     * @param itemIdAndQuantity product quantity and productId
     * @param principal         the logged in user (spring security)
     * @return HTTP
     * <p>
     * this method adds new items to the cart
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

    /**
     * @param itemId    item to be modified
     * @param quantity  the new quantity
     * @param principal actual user
     * @return returns the item with the new values
     */
    @PutMapping(path = "/{itemId}")
    public LineItems modifyItem(@PathVariable("itemId") String itemId, @RequestBody int quantity, Principal principal) {
        User user = userService.findOne(principal.getName());
        lineItemService.update(itemId, quantity, user);
        return lineItemService.findOne(itemId, user);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId, Principal principal) {
        User user = userService.findOne(principal.getName());
        cartService.delete(itemId, user);
    }

    @SneakyThrows
    @PostMapping("/checkout")
    public ResponseEntity<OrderProducts> checkout(Principal principal) {
        User user = userService.findOne(principal.getName());// Email
        if (user.getCart().getLineItems() == null)
            throw new CartItemsException("The cart cannot be empty");
        OrderProducts orderProducts = cartService.checkout(user);
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }
}
