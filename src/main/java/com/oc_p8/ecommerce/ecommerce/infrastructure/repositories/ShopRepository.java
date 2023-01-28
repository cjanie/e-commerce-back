package com.oc_p8.ecommerce.ecommerce.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.ShopDto;

public interface ShopRepository extends CrudRepository<ShopDto, Long> {
    
}
