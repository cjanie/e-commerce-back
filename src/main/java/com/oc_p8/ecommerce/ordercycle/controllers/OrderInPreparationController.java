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
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands.PassOrderIntoPreparationUseCase;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrdersInPreparationUseCase;
import com.oc_p8.ecommerce.ordercycle.controllers.dto.OrderActionDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands.OrderInPreparationCommandGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries.OrderInPreparationQueryGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

@RestController
@RequestMapping("/orders/preparation")
@CrossOrigin(origins = "*")
public class OrderInPreparationController {

    @Autowired
    private OrderCommandRepository commandRepository;

    @GetMapping
    public ResponseEntity<?> getOrdersInPreparation() {
        try {
            return new ResponseEntity<List<Order>>(
                    new GetOrdersInPreparationUseCase(new OrderInPreparationQueryGatewayImpl(new OrderQueryDAO()))
                            .handle(),
                    HttpStatus.OK);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping
    public ResponseEntity<?> passOrderIntoPreparation(@RequestBody OrderActionDTO action) {
        try {
            Long id = new PassOrderIntoPreparationUseCase(
                    new OrderInPreparationCommandGatewayImpl(this.commandRepository))
                    .handle(action.getOrderId(), action.getAssignee());
            return new ResponseEntity<Long>(id, HttpStatus.OK);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }

}
