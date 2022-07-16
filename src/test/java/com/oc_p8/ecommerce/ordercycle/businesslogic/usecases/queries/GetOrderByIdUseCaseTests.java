package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderDetailQueryGateway;

class InMemoryOrderDetailQueryGatewayImpl implements OrderDetailQueryGateway {

    @Override
    public Order getOrderById(Long id) {
        Order order = new OrderAtReceipt();
        order.setId(id);
        return order;
    }

}

public class GetOrderByIdUseCaseTests {

    @Test
    public void returnsOrder() throws PersistanceException {
        Long id = new GetOrderByIdUseCase(new InMemoryOrderDetailQueryGatewayImpl()).handle(1L).getId();
        assertEquals(1L, id);
    }

    @Test
    public void returnsOrderForId2IfAvailable() throws PersistanceException {
        Long id = new GetOrderByIdUseCase(new InMemoryOrderDetailQueryGatewayImpl()).handle(2L).getId();
        assertEquals(2L, id);
    }

    @Test
    public void returnsOrderWithStateAtReceipt() throws PersistanceException {
        Order order = new GetOrderByIdUseCase(new InMemoryOrderDetailQueryGatewayImpl()).handle(1L);
        assertEquals(OrderState.RECEIPT, order.state());
    }

    @Test
    void returnsOrderWithStateInPreparation() throws PersistanceException {
        Order order = new GetOrderByIdUseCase(new InMemoryOrderDetailQueryGatewayImpl()).handle(2L);
        assertEquals(OrderState.PREPARATION, order);
    }

}
