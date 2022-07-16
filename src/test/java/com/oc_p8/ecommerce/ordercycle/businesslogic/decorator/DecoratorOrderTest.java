package com.oc_p8.ecommerce.ordercycle.businesslogic.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class DecoratorOrderTest {

    @Test
    public void getDescriptionAtReceipt() {
        Order order = new OrderFactory().createOrder(1L, OrderState.RECEIPT, null);
        String historic = order.state() + " " + order.getHistoric();
        String expected = "RECEIPT Initial State RECEIPT.";
        assertEquals(expected, historic);
    }

    @Test
    public void getDescriptionOfReady() {
        Order order = new OrderFactory().createOrder(2L, OrderState.READY, "Jojo");
        String historic = order.state() + " " + order.getHistoric();
        String expected = "READY Initial State RECEIPT. New State PREPARATION by Assignee Jojo. New State READY by Assignee Jojo.";
        assertEquals(expected, historic);

    }
}
