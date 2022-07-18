package com.oc_p8.ecommerce.orderdata.businesslogic.usecases;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataQueryGateway;

public class GetOrderByIdUseCase {

    private OrderDataQueryGateway queryGateway;

    public GetOrderByIdUseCase(OrderDataQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public Order handle(Long id) throws PersistanceException {
        return this.queryGateway.getOrderById(id);
    }

}
