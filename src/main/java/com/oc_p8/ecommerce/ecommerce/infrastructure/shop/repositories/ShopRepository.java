package com.oc_p8.ecommerce.ecommerce.infrastructure.shop.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.dto.ShopDto;

public interface ShopRepository extends CrudRepository<ShopDto, Long> {
    
}
