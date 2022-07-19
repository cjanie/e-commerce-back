package com.oc_p8.ecommerce.orderdata.businesslogic.usecases;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataCommandGateway;

public class SaveOrderDataUseCase {

    private OrderDataCommandGateway commandGateway;

    public SaveOrderDataUseCase(OrderDataCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(Order order) throws PersistanceException {
        return commandGateway.saveOrder(order);
    }
}
