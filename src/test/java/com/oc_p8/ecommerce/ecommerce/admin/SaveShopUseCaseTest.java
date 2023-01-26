package com.oc_p8.ecommerce.ecommerce.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.gateways.ShopCommandGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.usecases.SaveShopUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;





class InMemoryShopCommandGateway implements ShopCommandGateway {

    @Override
    public Long save(Shop shop) {
        return shop.getId();
    }

}

public class SaveShopUseCaseTest {

    @Test
    public void returnsTheIdOfTheSavedShop() throws NullPayloadException, PersistanceException {
        InMemoryShopCommandGateway shopGateway = new InMemoryShopCommandGateway();

        Shop shop = new Shop();
        shop.setId(2L);
        Long id = new SaveShopUseCase(shopGateway).handle(shop);
        assertEquals(2, id);
    }

}