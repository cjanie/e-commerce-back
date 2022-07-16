package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderDetailQueryGateway;

public class GetOrderByIdUseCase {

    private OrderDetailQueryGateway queryGateway;

    public GetOrderByIdUseCase(OrderDetailQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public Order handle(Long id) throws PersistanceException {
        return this.queryGateway.getOrderById(id);
    }
}
