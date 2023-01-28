package com.oc_p8.ecommerce.ecommerce.businessLogic.entities;

public class Shop {

    private Long id;
    private String name;
    private Catalog catalog;
    private Stock stock;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Catalog getCatalog() {
        return this.catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    
}
