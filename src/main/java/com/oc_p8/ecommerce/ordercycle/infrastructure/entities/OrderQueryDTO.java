package com.oc_p8.ecommerce.ordercycle.infrastructure.entities;

public class OrderQueryDTO {

    private Long id;

    private Integer state;

    private String assignees;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAssignees() {
        return this.assignees;
    }

    public void setAssignees(String assignees) {
        this.assignees = assignees;
    }

}
