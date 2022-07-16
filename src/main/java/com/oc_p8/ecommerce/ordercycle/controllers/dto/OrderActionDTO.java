package com.oc_p8.ecommerce.ordercycle.controllers.dto;

public class OrderActionDTO {
    private Long orderId;
    private String assignee;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

}
