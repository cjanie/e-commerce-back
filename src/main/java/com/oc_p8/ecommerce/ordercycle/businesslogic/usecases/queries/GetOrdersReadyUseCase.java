package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderReadyQueryGateway;

public class GetOrdersReadyUseCase {
    private OrderReadyQueryGateway queryGateway;

    public GetOrdersReadyUseCase(OrderReadyQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<Order> handle() throws PersistanceException {
        return this.queryGateway.getOrdersWhereStateIsReady();
    }
}
