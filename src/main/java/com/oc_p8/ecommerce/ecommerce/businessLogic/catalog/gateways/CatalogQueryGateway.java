package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;

public interface CatalogQueryGateway {

    Catalog getById(Long id) throws PersistanceException;
}
