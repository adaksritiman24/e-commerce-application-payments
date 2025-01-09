package com.sritiman.ecommerce.payments.exceptions.payments;

import lombok.Getter;

@Getter
public class AccountNotFoundException extends RuntimeException{
    private final String details;
    public AccountNotFoundException(String message, String details) {
        super(message);
        this.details = details;
    }
}
