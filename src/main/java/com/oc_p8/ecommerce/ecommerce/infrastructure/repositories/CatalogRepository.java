package com.oc_p8.ecommerce.ecommerce.infrastructure.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.CatalogDTO;

public interface CatalogRepository extends CrudRepository<CatalogDTO, Long> {

}
