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
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands.SaveOrderAtReceiptUseCase;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrdersAtReceiptUseCase;
import com.oc_p8.ecommerce.ordercycle.controllers.dto.OrderSentDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands.OrderAtReceiptCommandGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries.OrderAtReceiptQueryGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

@RestController
@RequestMapping(value = "/orders/receipt")
@CrossOrigin(origins = "*")
public class OrderAtReceiptController {

    @Autowired
    OrderCommandRepository orderCommandRepository;

    @GetMapping
    public ResponseEntity<?> getOrdersAtReceipt() {
        try {
            List<Order> orders = new GetOrdersAtReceiptUseCase(new OrderAtReceiptQueryGatewayImpl(new OrderQueryDAO()))
                    .handle();
            return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);

        } catch (PersistanceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }

    @PostMapping
    public ResponseEntity<?> saveOrderAtReceipt(@RequestBody OrderSentDTO sentDTO) {
        try {
            OrderAtReceipt orderAtReceipt = sentDTO.format();

            return new ResponseEntity<Long>(
                    new SaveOrderAtReceiptUseCase(new OrderAtReceiptCommandGatewayImpl(this.orderCommandRepository))
                            .handle(orderAtReceipt),
                    HttpStatus.CREATED);

        } catch (PersistanceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
