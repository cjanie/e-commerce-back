package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogItemDTO;

public interface CatalogItemRepository extends CrudRepository<CatalogItemDTO, Long> {

}
