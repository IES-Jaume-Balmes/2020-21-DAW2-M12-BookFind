package com.findbook.demo.services;

import com.findbook.demo.dao.LineItemsRepository;
import com.findbook.demo.dao.OrderRepository;
import com.findbook.demo.dao.ShoppingCartRepository;
import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.Cart;
import com.findbook.demo.entities.LineItems;

import com.findbook.demo.entities.User;
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
    /*    @Autowired
        private BooksService booksService;*/
    @Autowired
    UserRepository userRepository;
    @Autowired
    LineItemsRepository lineItemsRepository;
    @Autowired
    OrderRepository orderRepository;

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
        var op = user.getCart().getLineItems().stream().filter(e -> itemId.equals(e.getLineItemsId())).findFirst();
        op.ifPresent(lineItemInOrder -> {
            lineItemInOrder.setCart(null);
            lineItemsRepository.deleteById(itemId);
        });
    }

    ///Checkout

/*    @Transactional
    public void checkout(User user) {
        Order order = new Order(user);
        orderRepository.save(order);
        *//**
     * Delate the reference of the cart into the product, reduce the stock
     * Loop throw all the available products in the cart and delete them
     *//*

        user.getCart().getLineItems().forEach(lineItems -> {
            lineItems.setCart(null);
            //Each item is related to an order, they will no longer be in a cart
            lineItems.setOrder(order);
          *//*    productService.decreaseStock(lineItems.getProductId(), lineItems.getCount());
            productInOrderRepository.save(lineItems);*//*
        });


    }*/


}
