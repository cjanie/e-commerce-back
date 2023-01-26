package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public interface ItemCommandGateway {
    Long save(Long catalogId, Item item) throws PersistanceException;
}
