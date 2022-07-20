package com.oc_p8.ecommerce.ecommerce;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import com.oc_p8.ecommerce.ecommerce.businessLogic.stock.useCases.CheckInStockUseCase;
import com.oc_p8.ecommerce.ecommerce.infrastructure.stock.adapters.InMemoryStockGateway;

import org.junit.jupiter.api.Test;

public class CheckInStockTests {

    @Test
    public void returnsInStockWhenProductsAreInStock() {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        stockGateway.setStock(Arrays.asList("tomates", "oignons", "olives"));
        boolean inStock = new CheckInStockUseCase(stockGateway).handle(Arrays.asList("tomates", "oignons", "olives"));
        assertTrue(inStock);
    }

    @Test
    public void notInStockWhenProductsAreNotInStock() {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        boolean inStock = new CheckInStockUseCase(stockGateway).handle(Arrays.asList("tomates"));
        assertFalse(inStock);
    }

}
