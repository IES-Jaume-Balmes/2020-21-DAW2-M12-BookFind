package com.findbook.demo.services;

import com.findbook.demo.dao.LineItemsRepository;
import com.findbook.demo.dao.ShoppingCartRepository;
import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.LineItems;
import com.findbook.demo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CartService {
    @Autowired
    private final ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private BooksService booksService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LineItemsRepository lineItemsRepository;

    public Cart getCart(User user) {
        return user.getCart();
    }


    @Transactional
    public void mergeLocalCart(Collection<LineItems> lineItems, User user) {
        Cart finalCart = user.getCart();
        lineItems.forEach(lineItems1 -> {
            Set<LineItems> set = finalCart.getLineItems();
            Optional<LineItems> old = set.stream().filter(e -> e.getBook().getBookId().equals(lineItems1.getBook().getBookId())).findFirst();
            LineItems prod;
            if (old.isPresent()) {
                prod = old.get();
                prod.setQuantity(lineItems1.getQuantity() + prod.getQuantity());
            } else {
                prod = lineItems1;
                prod.setCart(finalCart);
                finalCart.getLineItems().add(prod);
            }
            lineItemsRepository.save(prod);
        });
        shoppingCartRepository.save(finalCart);

    }
}
