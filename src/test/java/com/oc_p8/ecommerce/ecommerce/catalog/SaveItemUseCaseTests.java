package com.oc_p8.ecommerce.ecommerce.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.ItemCommandGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.Admin.SaveItemUseCase;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

class InMemoryItemCommandGatewayImpl implements ItemCommandGateway {

    @Override
    public Long save(Long catalogId, Item item) {
        return item.getId();
    }

}

public class SaveItemUseCaseTests {

    @Test
    public void returnsTheIdOfTheSavedItem() throws PersistanceException {
        Item item = new Item();
        item.setId(2L);
        Long actual = new SaveItemUseCase(new InMemoryItemCommandGatewayImpl()).handle(1L, item);
        assertEquals(2L, actual);
    }
}
