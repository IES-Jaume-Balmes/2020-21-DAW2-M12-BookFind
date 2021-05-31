package com.findbook.demo.services;

import com.findbook.demo.dao.*;
import com.findbook.demo.entities.*;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CartService {
    @Autowired
    private final ShoppingCartRepository shoppingCartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LineItemsRepository lineItemsRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BooksService booksService;

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
            if (old.isPresent()) {//If exists, add more elements
                prod = old.get();
                prod.setQuantity(lineItems1.getQuantity() + prod.getQuantity());
                //TODO:TEST THIS
                BigDecimal restar = prod.getTotalPrice();

                prod.setTotalPrice(prod.getBook().getPrice().multiply(new BigDecimal(prod.getQuantity())));

                BigDecimal total = new BigDecimal(String.valueOf(prod.getTotalPrice())).subtract(restar);
                finalCart.addNewProductMoney(total);
            } else {
                prod = lineItems1;
                prod.setCart(finalCart);

                finalCart.getLineItems().add(prod);

                BigDecimal total = new BigDecimal(String.valueOf(prod.getTotalPrice()));
                finalCart.addNewProductMoney(total);
            }
            lineItemsRepository.save(prod);
        });
        shoppingCartRepository.save(finalCart);

    }

    @Transactional
    public void delete(Long itemId, User user) {
        Cart userCart = user.getCart();
        var op = userCart.getLineItems().stream().filter(e -> itemId.equals(e.getLineItemsId())).findFirst();
        op.ifPresent(lineItemInOrder -> {
            BigDecimal totalToUpdate = new BigDecimal(lineItemInOrder.getTotalPrice().toString());
            BigDecimal total = new BigDecimal(userCart.getTotalMoney().toString());
            userCart.setTotalMoney(new BigDecimal(total.subtract(totalToUpdate).toString()));
            lineItemInOrder.setCart(null);
            lineItemsRepository.deleteById(itemId);
        });
    }

    @Transactional
    public OrderProducts checkout(User user) {
        OrderProducts order = new OrderProducts(user);

        order.setTotal(user.getCart().getTotalMoney());
        orderRepository.save(order);
        //TODO: ¿FRONT OR BACKEND?
        user.getCart().getLineItems().forEach(lineItems -> {
            lineItems.setCart(null);
            user.getCart().setTotalMoney(new BigDecimal(0));
            lineItems.setOrder(order);
            booksService.deleteFromStock(lineItems.getBook().getBookId(), lineItems.getQuantity());
            //Update each line-item y save it into the databases
            lineItemsRepository.save(lineItems);
        });
        return order;
    }


}
