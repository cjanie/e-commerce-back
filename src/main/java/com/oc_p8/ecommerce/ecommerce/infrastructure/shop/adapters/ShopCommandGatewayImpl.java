package com.oc_p8.ecommerce.ecommerce.infrastructure.shop.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways.ShopCommandGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.dto.ShopDto;
import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.repositories.ShopRepository;

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

        // Catalog
        Catalog catalog = shop.getCatalog();
        if(catalog != null) {
            CatalogDTO catalogDTO = new CatalogDTO();
            catalogDTO.setId(catalog.getId());
            catalogDTO.setShop(dto);

            if(!catalog.getItems().isEmpty()) {
                List<CatalogItemDTO> itemsDTOs = new ArrayList<>();
                catalog.getItems().forEach(item -> {
                    CatalogItemDTO itemDTO = new CatalogItemDTO();
                    itemDTO.setId(item.getId());
                    itemDTO.setName(item.getName());
                    itemDTO.setCatalog(catalogDTO);
                    itemsDTOs.add(itemDTO);
                });
                catalogDTO.setItems(itemsDTOs);
            }

            dto.setCatalog(catalogDTO);
        }
        
        return this.shopRepository.save(dto).getId();
        
    }
}
