package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderReadyCommandGateway;

class InMemoryOrderReadyCommandGatewayImpl implements OrderReadyCommandGateway {

    @Override
    public Long updateOrder(OrderReady orderReady) throws PersistanceException {
        return orderReady.getId();
    }

}

public class PassOrderToReadyUseCaseTest {

    private OrderFactory orderFactory = new OrderFactory();

    @Test
    public void orderHasTheSameId() throws PersistanceException {
        Order order = this.orderFactory.createOrderInPreparation(1L, "Janie");
        order = new OrderFactory().createOrderReady((OrderInPreparation) order, "Janie");

        Long actualId = new PassOrderToReadyUseCase(new InMemoryOrderReadyCommandGatewayImpl()).handle(order);
        assertEquals(1L, actualId);
    }

}
