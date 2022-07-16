package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderInPreparationQueryGateway;

class InMemoryOrderInPreparationQueryGatewayImpl implements OrderInPreparationQueryGateway {

    private List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrdersWhereStateIsInPreparation() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}

public class GetOrdersInPreparationUseCaseTest {

    // Clean Archi with In Memory Gateways impl

    @Test
    public void returnsOrdersWhenThereAreSomeInPreparation() throws PersistanceException {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        queryGateway
                .setOrders(Arrays.asList(new OrderFactory().createOrder(1L, OrderState.PREPARATION, "Jojo"),
                        new OrderFactory().createOrder(2L, OrderState.PREPARATION, "Jojo")));
        assertEquals(2, new GetOrdersInPreparationUseCase(queryGateway).handle().size());
    }

    @Test
    public void isEmptyWhenNothingInPreparation() throws PersistanceException {
        assertEquals(0,
                new GetOrdersInPreparationUseCase(new InMemoryOrderInPreparationQueryGatewayImpl()).handle().size());
    }

    // Requirements

    @Test
    public void returnsOrdersWhereOrderStateIsInPreparation() throws PersistanceException {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        queryGateway.setOrders(
                Arrays.asList(new OrderFactory().createOrder(1L, OrderState.PREPARATION, "Janon")));
        assertEquals(OrderState.PREPARATION, new GetOrdersInPreparationUseCase(queryGateway).handle().get(0).state());
    }

    @Test
    public void orderHasAssigneeJojo() throws PersistanceException {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        queryGateway
                .setOrders(Arrays.asList(new OrderFactory().createOrder(1L, OrderState.PREPARATION, "Jojo")));
        assertEquals("Jojo",
                ((OrderInPreparation) new GetOrdersInPreparationUseCase(queryGateway).handle().get(0)).assignee());
    }

    @Test
    public void orderHasAssigneeLola() throws PersistanceException {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        queryGateway
                .setOrders(Arrays.asList(new OrderFactory().createOrder(1L, OrderState.PREPARATION, "Lola")));
        assertEquals("Lola",
                ((OrderInPreparation) new GetOrdersInPreparationUseCase(queryGateway).handle().get(0)).assignee());
    }

}
