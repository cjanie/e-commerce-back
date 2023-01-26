package com.oc_p8.ecommerce.ecommerce.shops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways.ShopCommandGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.usecases.SaveShopUseCase;





class InMemoryShopCommandGateway implements ShopCommandGateway {

    @Override
    public Long save(Shop shop) {
        return shop.getId();
    }

}

public class SaveShopUseCaseTest {

    @Test
    public void returnsTheIdOfTheSavedShop() throws NullPayloadException {
        InMemoryShopCommandGateway shopGateway = new InMemoryShopCommandGateway();

        Shop shop = new Shop();
        shop.setId(2L);
        Long id = new SaveShopUseCase(shopGateway).handle(shop);
        assertEquals(2, id);
    }

}