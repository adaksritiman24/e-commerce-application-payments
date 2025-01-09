package com.sritiman.ecommerce.payments.exceptions.payments;

public class UnsupportedPaymentModeException extends RuntimeException{
    public UnsupportedPaymentModeException(String message) {
        super(message);
    }
}
