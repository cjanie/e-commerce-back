package com.oc_p8.ecommerce.ecommerce.shops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways.ShopQueryGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.usecases.GetShopsUseCase;

class InMemoryShopQueryGateway implements ShopQueryGateway {

    private List<Shop> shops;

    public InMemoryShopQueryGateway() {
        this.shops = new ArrayList<>();
    }

    @Override
    public List<Shop> findAll() {
        return this.shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
    
}

public class GetShopsUseCaseTest {

    @Test
    public void returnsShopsWhenThereAreSomeAvailable() {

        InMemoryShopQueryGateway shopQueryGateway = new InMemoryShopQueryGateway();

        List<Shop> shops = new ArrayList<>();
        shops.add(new Shop());
        shops.add(new Shop());

        shopQueryGateway.setShops(shops);
        
        assertEquals(2, new GetShopsUseCase(shopQueryGateway).handle().size());
    }
    
    @Test
    public void returnsNothingWhenNoShopIsAvailable() {

        InMemoryShopQueryGateway shopQueryGateway = new InMemoryShopQueryGateway();

        assertEquals(0, new GetShopsUseCase(shopQueryGateway).handle().size());
    }
}
