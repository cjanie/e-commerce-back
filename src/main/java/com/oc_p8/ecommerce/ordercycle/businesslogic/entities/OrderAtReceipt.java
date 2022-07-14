package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class OrderAtReceipt extends Order {

    @Override
    public OrderState state() {
        return OrderState.RECEIPT;
    }

}
