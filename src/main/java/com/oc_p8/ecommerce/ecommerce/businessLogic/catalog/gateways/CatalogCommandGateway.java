package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;

public interface CatalogCommandGateway {
    Long save(Catalog catalog);
}
