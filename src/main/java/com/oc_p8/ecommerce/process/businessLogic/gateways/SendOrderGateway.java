package com.oc_p8.ecommerce.process.businessLogic.gateways;

import com.oc_p8.ecommerce.process.businessLogic.entities.Order;

public interface SendOrderGateway {
    Long sendOrder(Order order);
}
