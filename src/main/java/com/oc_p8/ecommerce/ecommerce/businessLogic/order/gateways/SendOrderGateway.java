package com.oc_p8.ecommerce.ecommerce.businessLogic.order.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.order.entities.Order;

public interface SendOrderGateway {
    Long sendOrder(Order order);
}
