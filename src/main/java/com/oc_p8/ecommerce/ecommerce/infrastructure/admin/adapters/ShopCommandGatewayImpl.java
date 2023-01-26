package com.oc_p8.ecommerce.ecommerce.infrastructure.admin.adapters;

import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.gateways.ShopCommandGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.infrastructure.admin.dto.ShopDto;
import com.oc_p8.ecommerce.ecommerce.infrastructure.admin.repositories.ShopRepository;

public class ShopCommandGatewayImpl implements ShopCommandGateway {

    private ShopRepository shopRepository;

    public ShopCommandGatewayImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    
    

    @Override
    public Long save(Shop shop) throws NullPayloadException  {
        if(shop == null) {
            throw new NullPayloadException();
        }
        ShopDto dto = new ShopDto();
        dto.setId(shop.getId());
        dto.setName(shop.getName());
        
        return this.shopRepository.save(dto).getId();
        
    }
}
