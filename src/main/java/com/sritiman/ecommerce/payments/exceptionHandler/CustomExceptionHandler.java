package com.sritiman.ecommerce.payments.exceptionHandler;

import com.sritiman.ecommerce.payments.exceptions.payments.AccountNotFoundException;
import com.sritiman.ecommerce.payments.exceptions.payments.InsufficientBalanceException;
import com.sritiman.ecommerce.payments.exceptions.payments.UnsupportedPaymentModeException;
import com.sritiman.ecommerce.payments.model.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> accountNotFoundError(AccountNotFoundException accountNotFoundException) {
        return new ResponseEntity<>(new ErrorResponse(accountNotFoundException.getMessage(), accountNotFoundException.getDetails()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> insufficientBalanceError(InsufficientBalanceException insufficientBalanceException) {
        return new ResponseEntity<>(new ErrorResponse(insufficientBalanceException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnsupportedPaymentModeException.class)
    public ResponseEntity<ErrorResponse> unsupportedPaymentModeError(UnsupportedPaymentModeException unsupportedPaymentModeException) {
        return new ResponseEntity<>(new ErrorResponse(unsupportedPaymentModeException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
