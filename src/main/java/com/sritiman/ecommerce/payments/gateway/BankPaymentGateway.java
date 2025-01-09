package com.sritiman.ecommerce.payments.gateway;

import com.sritiman.ecommerce.payments.entities.Accounts;
import com.sritiman.ecommerce.payments.exceptions.payments.AccountNotFoundException;
import com.sritiman.ecommerce.payments.model.dtos.payments.PaymentAuthorizationRequest;
import com.sritiman.ecommerce.payments.repository.AccountsRepository;
import com.sritiman.ecommerce.payments.service.BuzzBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.sritiman.ecommerce.payments.constants.Constants.BUZZ_BUSINESS_ACCOUNT_NUMBER;

@Service
public class BankPaymentGateway implements PaymentGateway{
    private static final String ACCOUNT_NOT_FOUND = "Account not found";
    private static final String SUCCESS = "success";
    BuzzBankingService buzzBankingService;
    AccountsRepository accountsRepository;

    @Autowired
    public BankPaymentGateway(BuzzBankingService buzzBankingService, AccountsRepository accountsRepository) {
        this.buzzBankingService = buzzBankingService;
        this.accountsRepository = accountsRepository;
    }

    @Override
    public String capture(PaymentAuthorizationRequest paymentAuthorizationRequest) {

        String customerCardNumber = paymentAuthorizationRequest.getBankCard().getCardNumber();
        String cvv = paymentAuthorizationRequest.getBankCard().getCvv();

        Accounts merchantAccount = accountsRepository.findByAccountNumber(BUZZ_BUSINESS_ACCOUNT_NUMBER).stream().findFirst().orElse(null);
        Accounts customerAccount = accountsRepository.findByCardNumberAndCvv(customerCardNumber, cvv).stream().findFirst().orElse(null);

        if(Objects.isNull(merchantAccount)) {
            throw new AccountNotFoundException(ACCOUNT_NOT_FOUND, "merchant Account");
        }
        if(Objects.isNull(customerAccount)) {
            throw new AccountNotFoundException(ACCOUNT_NOT_FOUND, "customer Account");
        }
        double totalTransferAmount = paymentAuthorizationRequest.getCost().getTotalCost();
        Optional<Accounts> merchantOpt = accountsRepository.findById(merchantAccount.getId());
        Optional<Accounts> customerOpt = accountsRepository.findById(customerAccount.getId());

        if(merchantOpt.isPresent() && customerOpt.isPresent()) {
            buzzBankingService.doTransaction(customerOpt.get(), merchantOpt.get(), totalTransferAmount);
        }
        return SUCCESS;
    }
}
