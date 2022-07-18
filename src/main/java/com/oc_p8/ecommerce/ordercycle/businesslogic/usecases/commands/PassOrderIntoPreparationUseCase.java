package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderInPreparationCommandGateway;

public class PassOrderIntoPreparationUseCase {

    private OrderInPreparationCommandGateway commandGateway;

    public PassOrderIntoPreparationUseCase(OrderInPreparationCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(Long orderId, String assignee) throws PersistanceException {
        Order order = new OrderFactory().createOrderInPreparation(orderId, assignee);
        return this.commandGateway.updateOrder((OrderInPreparation) order);
    }

}
