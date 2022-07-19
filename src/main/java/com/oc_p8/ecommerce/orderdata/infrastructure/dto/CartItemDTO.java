package com.oc_p8.ecommerce.orderdata.infrastructure.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "cart_item")
@Table(name = "carts_items")
@Data
public class CartItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDataDTO order;

}
