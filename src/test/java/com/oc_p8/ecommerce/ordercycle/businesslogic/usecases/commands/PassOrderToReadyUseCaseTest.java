package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparationFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

class PassOrderToReadyUseCase {

    Order handle(Order order, String assignee) {

        order = OrderInPreparationFactory.getInstance().createOrderInPreparation(order.getId(), assignee);
        order = new OrderReady(order, assignee);
        return order;
    }
}

public class PassOrderToReadyUseCaseTest {

    @Test
    public void orderHasTheSameId() {
        Order order = new OrderAtReceipt();
        order.setId(1L);

        Order actual = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals(1L, actual.getId());
    }

    @Test
    public void orderHasAssignee() {
        Order order = new OrderAtReceipt();
        Order actual = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals("Janie", ((OrderReady) actual).assignee());
    }

    @Test
    public void orderStateIsReady() {
        Order order = new OrderAtReceipt();
        Order actual = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals(OrderState.READY, actual.state());
    }
}
