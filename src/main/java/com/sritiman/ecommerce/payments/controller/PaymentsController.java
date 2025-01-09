package com.sritiman.ecommerce.payments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentAuthorizationRequest;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentResponseDTO;
import com.sritiman.ecommerce.payments.service.IPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@CrossOrigin
public class PaymentsController {

    IPaymentsService paymentService;

    @Autowired
    public PaymentsController(IPaymentsService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/v1/capture")
    public ResponseEntity<PaymentResponseDTO> authorizeCapture(@RequestBody PaymentAuthorizationRequest paymentAuthorizationRequest) throws JsonProcessingException {
        PaymentResponseDTO paymentResponseDTO = paymentService.capturePayment(paymentAuthorizationRequest);
        System.out.println("Payment: "+paymentResponseDTO);
        return new ResponseEntity<>(paymentResponseDTO, HttpStatus.OK);
    }

}
