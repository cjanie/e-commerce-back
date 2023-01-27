package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;

public interface CatalogRepository extends CrudRepository<CatalogDTO, Long> {

}
