package com.sritiman.ecommerce.payments.model.dtos.payments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CostDTO {
    private double totalTax;
    private double subTotal;
    private double totalCost;
    private double shippingCost;
}
