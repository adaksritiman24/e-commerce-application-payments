package com.sritiman.ecommerce.payments.repository;

import com.sritiman.ecommerce.payments.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    List<Accounts> findByCardNumberAndCvv(String cardNumber, String cvv);
    List<Accounts> findByAccountNumber(String accountNumber);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE accounts SET balance= :balance where id= :id")
    void updateBalance(@Param("id") UUID id, @Param("balance") Double balance);
}
