package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderReadyCommandGateway;

public class PassOrderToReadyUseCase {

    private OrderReadyCommandGateway commandGateway;

    public PassOrderToReadyUseCase(OrderReadyCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(Order order) throws PersistanceException {
        return this.commandGateway.updateOrder((OrderReady) order);
    }
}
