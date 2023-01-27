package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.User;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogQueryGateway;

public class GetCatalogByShopIdUseCase {

    private CatalogQueryGateway catalogQueryGateway;

    

    public Catalog handle(Long shopId) {
        Catalog catalog = new Catalog();
        catalog.setId(1L);
        return catalog;
    }
    
}
