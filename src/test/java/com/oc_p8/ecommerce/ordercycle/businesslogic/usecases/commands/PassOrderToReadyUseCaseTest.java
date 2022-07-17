package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class PassOrderToReadyUseCaseTest {

    @Test
    public void orderHasTheSameId() {
        Order order = new OrderFactory().createOrder(1L);

        Order actual = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals(1L, actual.getId());
    }

    @Test
    public void orderHasAssignee() {
        Order order = new OrderFactory().createOrder(1L);
        Order actual = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals("Janie", ((OrderReady) actual).assignee());
    }

    @Test
    public void orderStateIsReady() {
        Order order = new OrderFactory().createOrder(1L);
        Order actual = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals(OrderState.READY, actual.state());
    }
}
