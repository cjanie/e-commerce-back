package com.oc_p8.ecommerce.ecommerce.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogQueryGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.User.GetCatalogByIdUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;

class InMemoryCatalogQueryGatewayImpl implements CatalogQueryGateway {

    @Override
    public Catalog getById(Long id) {
        Catalog catalog = new Catalog();
        catalog.setId(id);

        return catalog;
    }

    @Override
    public Catalog getByShopId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}

public class GetCatalogByIdUseCaseTests {

    @Test
    public void returnsCatalogWithRequestedId() throws PersistanceException {

        Catalog actual = new GetCatalogByIdUseCase(new InMemoryCatalogQueryGatewayImpl()).handle(1L);
        assertEquals(1L, actual.getId());
    }
}
