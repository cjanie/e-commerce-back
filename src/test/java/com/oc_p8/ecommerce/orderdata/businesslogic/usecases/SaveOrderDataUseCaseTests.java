package com.oc_p8.ecommerce.orderdata.businesslogic.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataCommandGateway;

class InMemoryOrderDataCommandGateway implements OrderDataCommandGateway {

    @Override
    public Long saveOrder(Order order) {
        return order.getId();
    }

}

public class SaveOrderDataUseCaseTests {

    @Test
    public void returnsId() throws PersistanceException {
        Order order = new Order();
        order.setId(1L);
        InMemoryOrderDataCommandGateway commandGateway = new InMemoryOrderDataCommandGateway();
        Long id = new SaveOrderDataUseCase(commandGateway).handle(order);
        assertEquals(1L, id);
    }

    @Test
    public void returnsTheIdOfTheSavedOrder() throws PersistanceException {
        Order order = new Order();
        order.setId(2L);
        InMemoryOrderDataCommandGateway commandGateway = new InMemoryOrderDataCommandGateway();
        Long id = new SaveOrderDataUseCase(commandGateway).handle(order);
        assertEquals(2L, id);
    }

}
