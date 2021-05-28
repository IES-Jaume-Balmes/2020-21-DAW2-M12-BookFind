package com.findbook.demo.dto;

import java.math.BigDecimal;


public class PaymentIntentDto {
    public enum Currency {USD, EUR}

    private String description;
    
    private BigDecimal amount;
    //Tipo de moneda
    private Currency currency;

    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
// </editor-fold>
}
