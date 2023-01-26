package com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;


public interface ShopCommandGateway {
    Long save(Shop shop) throws NullPayloadException;
}
