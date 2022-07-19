package com.oc_p8.ecommerce.orderdata.controllers.dto;

import java.util.List;

public class OrderSentDTO {

    private Long id;

    private String clientFirstName;

    private String clientLastName;

    private List<ItemDTO> items;

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

    public List<ItemDTO> getItems() {
        return this.items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

}
