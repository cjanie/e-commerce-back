package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.OrderReadyQueryGateway;

public class GetOrdersReadyUseCase {
    private OrderReadyQueryGateway queryGateway;

    public GetOrdersReadyUseCase(OrderReadyQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<Order> handle() {
        return this.queryGateway.getOrdersWhereStateIsReady();
    }
}
