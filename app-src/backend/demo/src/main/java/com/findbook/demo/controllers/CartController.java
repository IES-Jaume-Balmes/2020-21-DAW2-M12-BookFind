package com.findbook.demo.controllers;

import com.findbook.demo.entities.Book;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.LineItems;
import com.findbook.demo.entities.User;
import com.findbook.demo.dto.ItemForm;
import com.findbook.demo.services.BooksService;
import com.findbook.demo.services.CartService;
import com.findbook.demo.services.LineItemService;
import com.findbook.demo.services.UserService;
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
    private BooksService booksService; //Get info about the product
    @Autowired
    private CartService cartService;
    @Autowired
    private LineItemService lineItemService;

    @GetMapping("")
    public Cart getCart(Principal principal) {
        User user = userService.findOne(principal.getName());
        return cartService.getCart(user);
    }


    // TODO: REFACTOR, MABY THIS METHOD IS NOT NECESARY

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
     * @return HTTP
     */

    //TODO: returns http
    // @SneakyThrows
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

    //Modificar lineitem (add más cantidad o menos ) //cart/3?quantity=1 cart/id json 1
    //TODO: Añadir más seguridad, @Request param
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
        // flush memory into DB
    }

    //TODO: Al hacer checkout no puede esatar EMPTY el carrito
    //We need more info like direction or somethin
    @PostMapping("/checkout")
    public HttpStatus checkout(Principal principal) {
        //Instance of Principal object use "the string of the username
        User user = userService.findOne(principal.getName());// Email as username
        cartService.checkout(user);
        return HttpStatus.CREATED;
    }
}
