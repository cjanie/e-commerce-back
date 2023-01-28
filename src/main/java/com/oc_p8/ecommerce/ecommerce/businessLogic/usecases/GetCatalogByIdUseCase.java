package com.oc_p8.ecommerce.ecommerce.businessLogic.usecases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.CatalogQueryGateway;

public class GetCatalogByIdUseCase {

    private CatalogQueryGateway queryGateway;

    public GetCatalogByIdUseCase(CatalogQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public Catalog handle(Long id) throws PersistanceException {

        return this.queryGateway.getById(id);
    }

}
