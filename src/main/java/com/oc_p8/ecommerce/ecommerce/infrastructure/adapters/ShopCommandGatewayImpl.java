package com.oc_p8.ecommerce.ecommerce.infrastructure.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Stock;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.ShopCommandGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.CatalogItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.ShopDto;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.StockDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.repositories.ShopRepository;

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

            // Stock
        Stock stock = shop.getStock();

        if(stock != null) {
            StockDTO stockDTO = new StockDTO();
            stockDTO.setId(stock.getId());
            stockDTO.setShop(dto);
            
            if(!stock.getItems().isEmpty()) {
                List<StockItemDTO> itemsDTOs = new ArrayList<>();
                stock.getItems().forEach(item -> {
                    StockItemDTO itemDTO = new StockItemDTO();
                    itemDTO.setId(item.getId());
                    itemDTO.setName(item.getName());
                    itemDTO.setStock(stockDTO);
                    itemsDTOs.add(itemDTO);
                });
                stockDTO.setItems(itemsDTOs);
            }
            
            dto.setStock(stockDTO);
        }
        }
        
        return this.shopRepository.save(dto).getId();
        
    }
}
