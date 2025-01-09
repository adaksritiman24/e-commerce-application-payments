package com.sritiman.ecommerce.payments.gateway;

import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentAuthorizationRequest;
import org.springframework.stereotype.Service;

@Service
public class GiftCardPaymentGateway implements PaymentGateway{
    @Override
    public String capture(PaymentAuthorizationRequest paymentAuthorizationRequest) {
        return null;
    }
}
