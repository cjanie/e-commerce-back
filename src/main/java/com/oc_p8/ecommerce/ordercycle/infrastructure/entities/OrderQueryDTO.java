package com.oc_p8.ecommerce.ordercycle.infrastructure.entities;

public class OrderQueryDTO {

    private Long id;

    private String assignee;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

}
