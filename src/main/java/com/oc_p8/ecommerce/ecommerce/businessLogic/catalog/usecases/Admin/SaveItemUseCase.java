package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.Admin;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.ItemCommandGateway;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public class SaveItemUseCase {

    private ItemCommandGateway commandGateway;

    public SaveItemUseCase(ItemCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(Long catalogId, Item item) throws PersistanceException {
        return this.commandGateway.save(catalogId, item);
    }
}
