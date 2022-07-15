package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderAtReceiptCommandGateway;

class InMemoryOrderAtReceiptCommandGatewayImpl implements OrderAtReceiptCommandGateway {
    public Order order;

    @Override
    public Long save(OrderAtReceipt orderAtReceipt) {
        this.order = orderAtReceipt;
        return 1L;
    }

}

public class SaveOrderAtReceiptUseCaseTest {

    @Test
    public void returnsIdOfSavedOrder() {
        assertEquals(1L, new SaveOrderAtReceiptUseCase(new InMemoryOrderAtReceiptCommandGatewayImpl())
                .handle(new OrderAtReceipt()));
    }

    @Test
    public void stateOfSavedOrderIsAtReceipt() {
        InMemoryOrderAtReceiptCommandGatewayImpl commandGateway = new InMemoryOrderAtReceiptCommandGatewayImpl();
        SaveOrderAtReceiptUseCase saveOrderAtReceiptUseCase = new SaveOrderAtReceiptUseCase(commandGateway);
        saveOrderAtReceiptUseCase.handle(new OrderAtReceipt());
        assertEquals(OrderState.RECEIPT, commandGateway.order.state());
    }

}
