package com.sritiman.ecommerce.payments.model.dtos.payments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiftCardDTO {
    private String cardNumber;
    private String name;
}
