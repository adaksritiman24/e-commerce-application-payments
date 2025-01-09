package com.sritiman.ecommerce.payments.utilities;

import com.sritiman.ecommerce.payments.entities.Accounts;
import com.sritiman.ecommerce.payments.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static com.sritiman.ecommerce.payments.constants.Constants.BUZZ_BUSINESS_ACCOUNT_NUMBER;
import static com.sritiman.ecommerce.payments.constants.Constants.CUSTOMER_DUMMY_ACCOUNT_NUMBER;

@Component
public class AccountsDataStub implements CommandLineRunner {

    @Autowired
    AccountsRepository accountsRepository;


    @Override
    public void run(String... args) throws Exception {

        try {
            System.out.println("Populating AccountData");
            Accounts businessAccount = new Accounts();
            businessAccount.setBalance(5.00);
            businessAccount.setAccountNumber(BUZZ_BUSINESS_ACCOUNT_NUMBER);
            businessAccount.setCardNumber("4000300020001000");
            businessAccount.setCvv("123");
            businessAccount.setExpDate("12/34");
            businessAccount.setGiftCards(Collections.emptyList());
            businessAccount.setName("Buzz.co.in");
            accountsRepository.save(businessAccount);

            Accounts customerAccount = new Accounts();
            customerAccount.setBalance(500000.00);
            customerAccount.setAccountNumber(CUSTOMER_DUMMY_ACCOUNT_NUMBER);
            customerAccount.setCardNumber("4111111111111111");
            customerAccount.setCvv("123");
            customerAccount.setExpDate("12/34");
            customerAccount.setGiftCards(Collections.emptyList());
            customerAccount.setName("Sritiman Adak");
            accountsRepository.save(customerAccount);
        }
        catch (Exception e) {
            System.out.println("[AccountStub error]: "+ e.getMessage());
        }
    }
}
