package com.oc_p8.ecommerce.ecommerce.businessLogic.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;


public interface ShopCommandGateway {
    Long save(Shop shop) throws NullPayloadException;
}
