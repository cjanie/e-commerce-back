package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;

class PassOrderToReadyUseCase {

    Long handle(Order order, String assignee) {

        return order.getId();
    }
}

public class PassOrderToReadyUseCaseTest {

    @Test
    public void orderHasTheSameId() {
        Order order = new OrderAtReceipt();
        order.setId(1L);

        Long id = new PassOrderToReadyUseCase().handle(order, "Janie");
        assertEquals(1L, id);
    }
}
