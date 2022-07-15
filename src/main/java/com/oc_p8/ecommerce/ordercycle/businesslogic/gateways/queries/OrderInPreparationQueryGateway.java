package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;

public interface OrderInPreparationQueryGateway {
    List<Order> getOrdersWhereStateIsInPreparation();
}
