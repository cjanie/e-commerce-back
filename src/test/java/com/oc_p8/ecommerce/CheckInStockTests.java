package com.oc_p8.ecommerce;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oc_p8.ecommerce.businessLogic.gateways.StockGateway;
import com.oc_p8.ecommerce.businessLogic.useCases.CheckInStockUseCase;

import org.junit.jupiter.api.Test;


class InMemoryStockGatewayImpl implements StockGateway {

    List<String> stock = new ArrayList<>();

    @Override
    public List<String> getStock() {
        return this.stock;
    }

    public void setStock(List<String> stock) {
        this.stock = stock;
    }
}

public class CheckInStockTests {
    
    @Test
    public void returnsInStockWhenProductsAreInStock() {
        InMemoryStockGatewayImpl stockGateway = new InMemoryStockGatewayImpl();
        stockGateway.setStock(Arrays.asList("tomates", "oignons", "olives"));
        boolean inStock = new CheckInStockUseCase(stockGateway).handle(Arrays.asList("tomates", "oignons", "olives"));
        assertTrue(inStock);
    }

    @Test
    public void notInStockWhenProductsAreNotInStock() {
        InMemoryStockGatewayImpl stockGateway = new InMemoryStockGatewayImpl();
        boolean inStock = new CheckInStockUseCase(stockGateway).handle(Arrays.asList("tomates"));
        assertFalse(inStock);
    }

}
