package com.oc_p8.ecommerce.ecommerce.infrastructure.admin.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ecommerce.infrastructure.admin.dto.ShopDto;

public interface ShopRepository extends CrudRepository<ShopDto, Long> {
    
}
