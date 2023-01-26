package com.oc_p8.ecommerce.ecommerce.businessLogic.admin.gateways;

import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;


public interface ShopCommandGateway {
    Long save(Shop shop) throws NullPayloadException;
}
