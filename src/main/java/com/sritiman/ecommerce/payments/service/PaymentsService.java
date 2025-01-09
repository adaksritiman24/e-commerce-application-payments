package com.sritiman.ecommerce.payments.service;

import com.sritiman.ecommerce.payments.exceptions.payments.UnsupportedPaymentModeException;
import com.sritiman.ecommerce.payments.gateway.BankPaymentGateway;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentAuthorizationRequest;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentModeDTO;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sritiman.ecommerce.payments.constants.Constants.PAYMENT_FAILURE;
import static com.sritiman.ecommerce.payments.constants.Constants.PAYMENT_SUCCESS;

@Service
public class PaymentsService implements IPaymentsService {

    BankPaymentGateway bankPaymentGateway;

    @Autowired
    public PaymentsService(BankPaymentGateway bankPaymentGateway) {
        this.bankPaymentGateway = bankPaymentGateway;
    }

    @Override
    public PaymentResponseDTO capturePayment(PaymentAuthorizationRequest paymentAuthorizationRequest) {
        if(PaymentModeDTO.BANK_CARD.equals(paymentAuthorizationRequest.getPaymentMode())) {
            String captureStatus = bankPaymentGateway.capture(paymentAuthorizationRequest);

            if(captureStatus.equalsIgnoreCase(PAYMENT_SUCCESS)) {
                return PaymentResponseDTO.builder().status(PAYMENT_SUCCESS).build();
            }
            else {
                return PaymentResponseDTO.builder().status(PAYMENT_FAILURE).build();
            }
        }else {
            throw new UnsupportedPaymentModeException("PaymentMode not Supported");
        }
    }
}
