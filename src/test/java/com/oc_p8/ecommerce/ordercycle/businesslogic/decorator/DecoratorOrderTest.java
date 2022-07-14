package com.oc_p8.ecommerce.ordercycle.businesslogic.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Client;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;

public class DecoratorOrderTest {

    private Client createClient() {
        Client client = new Client();
        client.setFirstName("Jojo");
        client.setLastName("Tronchon");
        return client;
    }

    private Cart createCart() {
        Cart cart = new Cart();
        cart.getItems().addAll(Arrays.asList("item1", "item2"));
        return cart;
    }

    @Test
    public void getDescriptionAtReceipt() {
        Order order = new OrderAtReceipt();
        order.setId(1L);
        order.setClient(this.createClient());
        order.setCart(this.createCart());
        String historic = order.state() + " " + order.getHistoric();
        String expected = "RECEIPT Initial State RECEIPT.";
        assertEquals(expected, historic);
    }

    @Test
    public void getDescriptionOfReady() {
        Order order = new OrderAtReceipt();
        order.setId(2L);
        order.setClient(this.createClient());
        order.setCart(this.createCart());
        order = new OrderInPreparation(order, "Jojo");
        order = new OrderReady(order, "Jojo");
        String historic = order.state() + " " + order.getHistoric();
        String expected = "READY Initial State RECEIPT. New State PREPARATION by Assignee Jojo. New State READY by Assignee Jojo.";
        assertEquals(expected, historic);

    }
}
