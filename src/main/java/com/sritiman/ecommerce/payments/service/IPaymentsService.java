package com.sritiman.ecommerce.payments.service;

import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentAuthorizationRequest;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentResponseDTO;

public interface IPaymentsService {
    public PaymentResponseDTO capturePayment(PaymentAuthorizationRequest paymentAuthorizationRequest);
}
