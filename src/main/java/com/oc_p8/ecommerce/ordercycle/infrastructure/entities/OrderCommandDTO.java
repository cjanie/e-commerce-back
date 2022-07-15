package com.oc_p8.ecommerce.ordercycle.infrastructure.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

import lombok.Data;

@Entity(name = "order")
@Table(name = "orders")
@Data
public class OrderCommandDTO {

    @Id
    private Long id;

    @Column
    private String clientFirstName;

    @Column
    private String clientLastName;

    // TODO Cart

    @Column
    private OrderState state;

}
