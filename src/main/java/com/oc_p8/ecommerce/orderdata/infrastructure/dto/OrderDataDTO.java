package com.oc_p8.ecommerce.orderdata.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "order_data")
@Table(name = "orders_data")
@Data
public class OrderDataDTO {

    @Id
    private Long id;

    @Column
    private String clientFirstName;

    @Column
    private String clientLastName;

    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CartItemDTO> cartItems;

}
