package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.OrderInPreparationQueryGateway;

public class GetOrdersInPreparationUseCase {
    private OrderInPreparationQueryGateway queryGateway;

    public GetOrdersInPreparationUseCase(OrderInPreparationQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<Order> handle() {
        return this.queryGateway.getOrdersWhereStateIsInPreparation();
    }
}
