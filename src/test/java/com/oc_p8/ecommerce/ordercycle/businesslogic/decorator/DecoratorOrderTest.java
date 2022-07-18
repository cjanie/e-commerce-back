package com.oc_p8.ecommerce.ordercycle.businesslogic.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;

public class DecoratorOrderTest {

    private OrderFactory orderFactory = new OrderFactory();

    @Test
    public void getHistoricOfAtReceipt() {
        Order order = this.orderFactory.createOrderAtReceipt(1L);
        String historic = order.state() + " " + order.getHistoric();
        String expected = "RECEIPT Initial State RECEIPT.";
        assertEquals(expected, historic);
    }

    @Test
    public void getHistoricOfInPreparation() {
        Order order = this.orderFactory.createOrderInPreparation(2L, "Jo");
        String historic = order.state() + " " + order.getHistoric();
        String expected = "PREPARATION Initial State RECEIPT. New State PREPARATION by Jo.";
        assertEquals(expected, historic);
    }

    @Test
    public void getHistoricOfReady() {
        Order order = this.orderFactory.createOrderInPreparation(2L, "Jo");
        order = this.orderFactory.createOrderReady((OrderInPreparation) order, "Jojo");
        String historic = order.state() + " " + order.getHistoric();
        String expected = "READY Initial State RECEIPT. New State PREPARATION by Jo. New State READY by Jojo.";
        assertEquals(expected, historic);

    }
}
