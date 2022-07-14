package com.oc_p8.ecommerce.ordercycle.infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Client;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.OrderReadyQueryGateway;

public class OrderReadyQueryGatewayImpl implements OrderReadyQueryGateway {

    private List<Order> orders;

    public OrderReadyQueryGatewayImpl() {
        this.orders = new ArrayList<>();
        Order order = new OrderAtReceipt();
        order.setId(3L);
        Client client = new Client();
        client.setFirstName("Jojo");
        client.setLastName("Tronchon");
        order.setClient(client);
        Cart cart = new Cart();
        cart.getItems().addAll(Arrays.asList("item1", "item2"));
        order.setCart(cart);
        order = new OrderInPreparation(order, "Jojo");
        order = new OrderReady(order, "Jojo");

        orders.add(order);
    }

    @Override
    public List<Order> getOrdersWhereStateIsReady() {
        return this.orders;
    }

}
