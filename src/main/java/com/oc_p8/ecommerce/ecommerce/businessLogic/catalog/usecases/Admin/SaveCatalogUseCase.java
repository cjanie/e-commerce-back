package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.Admin;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogCommandGateway;

public class SaveCatalogUseCase {

    private CatalogCommandGateway catalogCommandGateway;

    public SaveCatalogUseCase(CatalogCommandGateway catalogCommandGateway) {
        this.catalogCommandGateway = catalogCommandGateway;
    }

    public Long handle(Catalog catalog) {
        return this.catalogCommandGateway.save(catalog);
    } 
    
}
