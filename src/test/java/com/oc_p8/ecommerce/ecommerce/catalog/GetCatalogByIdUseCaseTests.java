package com.oc_p8.ecommerce.ecommerce.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.CatalogQueryGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.usecases.GetCatalogByIdUseCase;

class InMemoryCatalogQueryGatewayImpl implements CatalogQueryGateway {

    @Override
    public Catalog getById(Long id) {
        Catalog catalog = new Catalog();
        catalog.setId(id);

        return catalog;
    }

}

public class GetCatalogByIdUseCaseTests {

    @Test
    public void returnsCatalogWithRequestedId() throws PersistanceException {

        Catalog actual = new GetCatalogByIdUseCase(new InMemoryCatalogQueryGatewayImpl()).handle(1L);
        assertEquals(1L, actual.getId());
    }
}
