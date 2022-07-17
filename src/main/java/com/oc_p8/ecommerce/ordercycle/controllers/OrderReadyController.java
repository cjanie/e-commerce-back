package com.oc_p8.ecommerce.ordercycle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands.PassOrderToReadyUseCase;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrderByIdUseCase;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrdersReadyUseCase;
import com.oc_p8.ecommerce.ordercycle.controllers.dto.OrderActionDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands.OrderReadyCommandGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries.OrderDetailQueryGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries.OrderReadyQueryGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

@RestController
@RequestMapping("/orders/ready")
@CrossOrigin(origins = "*")
public class OrderReadyController {

    @Autowired
    private OrderCommandRepository commandRepository;

    @GetMapping
    public ResponseEntity<?> getOrdersReady() {
        try {
            return new ResponseEntity<List<Order>>(
                    new GetOrdersReadyUseCase(new OrderReadyQueryGatewayImpl(new OrderQueryDAO())).handle(),
                    HttpStatus.OK);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping
    public ResponseEntity<?> passOrderToReady(@RequestBody OrderActionDTO actionDTO) {
        try {
            Order order = new GetOrderByIdUseCase(new OrderDetailQueryGatewayImpl(new OrderQueryDAO()))
                    .handle(actionDTO.getOrderId());
            order = new OrderFactory().createOrderReady(order, actionDTO.getAssignee());
            Long id = new PassOrderToReadyUseCase(new OrderReadyCommandGatewayImpl(this.commandRepository))
                    .handle(order);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }
}
