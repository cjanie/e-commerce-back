package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderAtReceiptQueryGateway;

class InMemoryOrderAtReceiptQueryGatewayImpl implements OrderAtReceiptQueryGateway {

    private List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrdersWhereStateIsAtReceipt() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}

public class GetOrdersAtReceiptUseCaseTests {

    // Clean Archi with In Memory Gateways impl

    @Test
    public void returnsOrdersWhenThereAreSomeAtReceipt() throws PersistanceException {
        InMemoryOrderAtReceiptQueryGatewayImpl queryGateway = new InMemoryOrderAtReceiptQueryGatewayImpl();
        queryGateway.setOrders(Arrays.asList(new OrderFactory().createOrder(1L), new OrderFactory().createOrder(2L)));
        assertEquals(2, new GetOrdersAtReceiptUseCase(queryGateway).handle().size());
    }

    @Test
    public void isEmptyWhenNothingAtReceipt() throws PersistanceException {
        assertEquals(0, new GetOrdersAtReceiptUseCase(new InMemoryOrderAtReceiptQueryGatewayImpl()).handle().size());
    }

    // Requirement

    @Test
    public void returnsOrdersWhereOrderStateIsAtReceipt() throws PersistanceException {
        InMemoryOrderAtReceiptQueryGatewayImpl queryGateway = new InMemoryOrderAtReceiptQueryGatewayImpl();
        queryGateway.setOrders(Arrays.asList(new OrderFactory().createOrder(1L)));
        assertEquals(OrderState.RECEIPT, new GetOrdersAtReceiptUseCase(queryGateway).handle().get(0).state());
    }
}
