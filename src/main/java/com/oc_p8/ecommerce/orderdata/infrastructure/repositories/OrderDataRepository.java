package com.oc_p8.ecommerce.orderdata.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oc_p8.ecommerce.orderdata.infrastructure.dto.OrderDataDTO;

public interface OrderDataRepository extends CrudRepository<OrderDataDTO, Long> {

}
