package com.oc_p8.ecommerce.ordercycle.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrderByIdUseCase;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries.OrderDetailQueryGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderDetailController {

    @GetMapping()
    public ResponseEntity<?> getOrderById(@RequestParam(value = "id") Long id) {
        try {
            Order order = new GetOrderByIdUseCase(new OrderDetailQueryGatewayImpl(new OrderQueryDAO())).handle(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } catch (PersistanceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
