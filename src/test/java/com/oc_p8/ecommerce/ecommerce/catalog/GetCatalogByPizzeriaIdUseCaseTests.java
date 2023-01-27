package com.oc_p8.ecommerce.ecommerce.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.User.GetCatalogByShopIdUseCase;

public class GetCatalogByPizzeriaIdUseCaseTests {
    
    @Test
    public void returnsCatalogWhenFound() {
        Long PizzeriaId = 1L;
        Catalog catalog = new GetCatalogByShopIdUseCase().handle(PizzeriaId);
        assertEquals(2, catalog.getId());
    }
}
