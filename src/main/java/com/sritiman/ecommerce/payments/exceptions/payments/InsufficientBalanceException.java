package com.sritiman.ecommerce.payments.exceptions.payments;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
