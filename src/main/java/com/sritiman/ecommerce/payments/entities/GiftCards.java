package com.sritiman.ecommerce.payments.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GiftCards {
    private String cardId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
