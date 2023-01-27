package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogQueryGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories.CatalogRepository;

public class CatalogQueryGatewayImpl implements CatalogQueryGateway {

    private CatalogRepository catalogRepository;

    public CatalogQueryGatewayImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog getById(Long id) throws PersistanceException {

        try {
            CatalogDTO catalogDTO = this.catalogRepository.findById(id).get();

            return this.convertCatalogDtoToEntity(catalogDTO);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

    

    private Catalog convertCatalogDtoToEntity(CatalogDTO catalogDTO) {
        Catalog catalog = new Catalog();
        catalog.setId(catalogDTO.getId());

        return catalog;
    }

    @Override
    public Catalog getByShopId(Long shopId) {
        CatalogDTO dto = this.catalogRepository.findByShopId(shopId);
        return null;
    }

}
