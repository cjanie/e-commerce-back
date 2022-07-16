package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderInPreparationCommandGateway;

public class PassOrderIntoPreparationUseCase {

    private OrderInPreparationCommandGateway commandGateway;

    public PassOrderIntoPreparationUseCase(OrderInPreparationCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(Order order, String assignee) throws PersistanceException {
        OrderInPreparation orderInPreparation = new OrderInPreparation(order, assignee);
        return this.commandGateway.updateOrder(orderInPreparation);
    }

}
