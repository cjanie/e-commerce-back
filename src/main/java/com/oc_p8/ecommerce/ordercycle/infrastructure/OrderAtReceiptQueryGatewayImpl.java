package com.oc_p8.ecommerce.ordercycle.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Client;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.OrderAtReceiptQueryGateway;

public class OrderAtReceiptQueryGatewayImpl implements OrderAtReceiptQueryGateway {

    private List<Order> orders;

    public OrderAtReceiptQueryGatewayImpl() {
        this.orders = new ArrayList<>();

        Order order = new OrderAtReceipt();
        order.setId(1L);
        Client client = new Client();
        client.setFirstName("Jojo");
        client.setLastName("Tronchon");
        order.setClient(client);
        Cart cart = new Cart();
        cart.getItems().addAll(Arrays.asList("item1", "item2"));
        order.setCart(cart);
        this.orders.add(order);
    }

    @Override
    public List<Order> getOrdersWhereStateIsAtReceipt() {
        return this.orders;
    }

}

class OrderQueryDao {

    private String url = "databaseUrl";
    private String user = "username";
    private String password = "password";

    private Connection connection;

    public OrderQueryDao() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    private String request = "SELECT * FROM order WHERE order.state =?";

}
