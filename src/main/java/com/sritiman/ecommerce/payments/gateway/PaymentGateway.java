package com.sritiman.ecommerce.payments.gateway;

import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentAuthorizationRequest;

public interface PaymentGateway {
    String capture(PaymentAuthorizationRequest paymentAuthorizationRequest);
}
