package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderReadyQueryGateway;

class InMemoryOrderReadyQueryGatewayImpl implements OrderReadyQueryGateway {

    private List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrdersWhereStateIsReady() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}

public class GetOrdersReadyUseCaseTest {

    // Clean Archi with In Memory Gateways impl

    @Test
    public void returnsOrdersWhenThereAreSomeReady() throws PersistanceException {
        InMemoryOrderReadyQueryGatewayImpl queryGateway = new InMemoryOrderReadyQueryGatewayImpl();
        queryGateway.setOrders(Arrays.asList(new OrderFactory().createOrder(1L, OrderState.READY, "Jo"),
                new OrderFactory().createOrder(2L, OrderState.READY, "Jano")));
        assertEquals(2, new GetOrdersReadyUseCase(queryGateway).handle().size());
    }

    @Test
    public void isEmptyWhenNothingReady() throws PersistanceException {
        assertEquals(0,
                new GetOrdersReadyUseCase(new InMemoryOrderReadyQueryGatewayImpl()).handle().size());
    }

    // Requirements

    @Test
    public void returnsOrdersWhereOrderStateIsReady() throws PersistanceException {
        InMemoryOrderReadyQueryGatewayImpl queryGateway = new InMemoryOrderReadyQueryGatewayImpl();
        Order order = new OrderFactory().createOrder(1L, OrderState.READY, "Jojo");
        queryGateway.setOrders(Arrays.asList(order));
        assertEquals(OrderState.READY, new GetOrdersReadyUseCase(queryGateway).handle().get(0).state());
    }

    @Test
    public void orderHasAssignee() throws PersistanceException {
        InMemoryOrderReadyQueryGatewayImpl queryGateway = new InMemoryOrderReadyQueryGatewayImpl();
        Order order = new OrderFactory().createOrder(1L, OrderState.READY, "Jojo");
        queryGateway.setOrders(Arrays.asList(order));
        assertEquals("Jojo", ((OrderReady) new GetOrdersReadyUseCase(queryGateway).handle().get(0)).assignee());
    }

}
