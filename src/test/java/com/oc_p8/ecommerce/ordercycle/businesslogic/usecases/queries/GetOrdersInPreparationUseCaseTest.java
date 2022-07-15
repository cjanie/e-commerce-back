package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
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
    public void returnsOrdersWhenThereAreSomeInPreparation() {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        Order order = new OrderAtReceipt();
        queryGateway
                .setOrders(Arrays.asList(new OrderInPreparation(order, "Jojo"), new OrderInPreparation(order, "Jojo")));
        assertEquals(2, new GetOrdersInPreparationUseCase(queryGateway).handle().size());
    }

    @Test
    public void isEmptyWhenNothingInPreparation() {
        assertEquals(0,
                new GetOrdersInPreparationUseCase(new InMemoryOrderInPreparationQueryGatewayImpl()).handle().size());
    }

    // Requirements

    @Test
    public void returnsOrdersWhereOrderStateIsInPreparation() {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        Order order = new OrderAtReceipt();
        queryGateway.setOrders(Arrays.asList(new OrderInPreparation(order, "Janon")));
        assertEquals(OrderState.PREPARATION, new GetOrdersInPreparationUseCase(queryGateway).handle().get(0).state());
    }

    @Test
    public void orderHasAssigneeJojo() {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        Order order = new OrderAtReceipt();
        queryGateway.setOrders(Arrays.asList(new OrderInPreparation(order, "Jojo")));
        assertEquals("Jojo",
                ((OrderInPreparation) new GetOrdersInPreparationUseCase(queryGateway).handle().get(0)).assignee());
    }

    @Test
    public void orderHasAssigneeLola() {
        InMemoryOrderInPreparationQueryGatewayImpl queryGateway = new InMemoryOrderInPreparationQueryGatewayImpl();
        Order order = new OrderAtReceipt();
        queryGateway.setOrders(Arrays.asList(new OrderInPreparation(order, "Lola")));
        assertEquals("Lola",
                ((OrderInPreparation) new GetOrdersInPreparationUseCase(queryGateway).handle().get(0)).assignee());
    }

}
