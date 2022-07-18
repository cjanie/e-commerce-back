package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderReadyCommandGateway;

public class SaveOrderReadyUseCase {

    private OrderReadyCommandGateway commandGateway;

    public SaveOrderReadyUseCase(OrderReadyCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(Order order) throws PersistanceException {
        return this.commandGateway.updateOrder((OrderReady) order);
    }
}
