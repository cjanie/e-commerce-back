package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogCommandGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories.CatalogRepository;

public class CatalogCommandGatewayImpl implements CatalogCommandGateway{

    private CatalogRepository catalogRepository;

    public CatalogCommandGatewayImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Long save(Catalog catalog) {
        CatalogDTO catalogDTO = new CatalogDTO();
        catalogDTO.setId(catalog.getId());
        if(!catalog.getItems().isEmpty()) {
            List<CatalogItemDTO> catalogItemsDTOs = new ArrayList<>();
            catalog.getItems().forEach(item -> {
                CatalogItemDTO catalogItemDTO = new CatalogItemDTO();
                catalogItemDTO.setId(item.getId());
                catalogItemDTO.setName(item.getName());
                catalogItemDTO.setCatalog(catalogDTO);
                catalogItemsDTOs.add(catalogItemDTO);
            });
            catalogDTO.setItems(catalogItemsDTOs);
        }
        return this.catalogRepository.save(catalogDTO).getId();
    }


    
}
