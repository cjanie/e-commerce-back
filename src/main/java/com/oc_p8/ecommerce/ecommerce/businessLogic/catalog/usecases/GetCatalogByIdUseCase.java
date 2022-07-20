package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogQueryGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;

public class GetCatalogByIdUseCase {

    private CatalogQueryGateway queryGateway;

    public GetCatalogByIdUseCase(CatalogQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public Catalog handle(Long id) throws PersistanceException {

        return this.queryGateway.getById(id);
    }

}
