package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;

public interface OrderReadyQueryGateway {
    List<Order> getOrdersWhereStateIsReady();
}
