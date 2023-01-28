package com.oc_p8.ecommerce.ecommerce.infrastructure.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "catalog_item")
@Table(name = "catalogs_items")
public class CatalogItemDTO extends ItemDTO {

    @Column
    private Float price;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="catalog_id")
    private CatalogDTO catalog;


    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    

    public CatalogDTO getCatalog() {
        return this.catalog;
    }

    public void setCatalog(CatalogDTO catalog) {
        this.catalog = catalog;
    }

}