package com.findbook.demo.services;


import com.findbook.demo.dao.LineItemsRepository;

import com.findbook.demo.entities.LineItems;
import com.findbook.demo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class LineItemService {

    @Autowired
    LineItemsRepository lineItemsRepository;

    @Transactional
    public void update(String itemId, Integer quantity, User user) {
        var op = user.getCart().getLineItems().stream().filter(e -> itemId.equals(e.getLineItemsId().toString())).findFirst();
        op.ifPresent(productInOrder -> { //Si el libro existe
            productInOrder.setQuantity(quantity);
            //TODO: REVISAR
            ///NO FUNCIONA, TEST
            BigDecimal actualPrice = new BigDecimal(productInOrder.getTotalPrice().toString());
            BigDecimal cartPrice = new BigDecimal(user.getCart().getTotalMoney().toString());
            BigDecimal price = new BigDecimal(String.valueOf(actualPrice.subtract(cartPrice)));

            productInOrder.setTotalPrice(productInOrder.getBook().getPrice().multiply(new BigDecimal(productInOrder.getQuantity())));
            user.getCart().setTotalMoney(new BigDecimal(productInOrder.getTotalPrice().add(price).toString()));
            lineItemsRepository.save(productInOrder);
        });
    }

    public LineItems findOne(String itemId, User user) {
        var op = user.getCart().getLineItems().stream().filter(e -> itemId.equals(e.getLineItemsId().toString())).findFirst();
        AtomicReference<LineItems> res = new AtomicReference<>();
        op.ifPresent(res::set);
        return res.get();
    }

}
