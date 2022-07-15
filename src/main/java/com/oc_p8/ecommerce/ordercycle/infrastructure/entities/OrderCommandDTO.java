package com.oc_p8.ecommerce.ordercycle.infrastructure.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

// TODO Hibernate JPA annotations

public class OrderCommandDTO {

    private Long id;

    private String clientFirstName;

    private String clientLastName;

    // TODO Cart

    private OrderState state;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientFirstName() {
        return this.clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return this.clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public OrderState getState() {
        return this.state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

}
