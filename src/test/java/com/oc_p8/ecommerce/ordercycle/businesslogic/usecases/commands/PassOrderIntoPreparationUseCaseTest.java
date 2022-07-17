package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderInPreparationCommandGateway;

class InMemoryOrderInPreparationCommandGatewayImpl implements OrderInPreparationCommandGateway {

    @Override
    public Long updateOrder(OrderInPreparation order) {
        return order.getId();
    }

}

public class PassOrderIntoPreparationUseCaseTest {

    @Test
    public void orderIsUpdateWithTheSameId() throws PersistanceException {
        Long id = new PassOrderIntoPreparationUseCase(
                new InMemoryOrderInPreparationCommandGatewayImpl()).handle(1L, "Jo");
        assertEquals(1L, id);
    }
}
