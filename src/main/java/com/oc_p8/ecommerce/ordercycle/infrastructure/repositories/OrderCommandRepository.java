package com.oc_p8.ecommerce.ordercycle.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderCommandDTO;

public interface OrderCommandRepository extends CrudRepository<OrderCommandDTO, Long> {

}
