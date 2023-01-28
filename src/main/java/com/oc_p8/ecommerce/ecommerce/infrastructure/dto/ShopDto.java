package com.oc_p8.ecommerce.ecommerce.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "shop")
@Table(name = "shops")
public class ShopDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_id", referencedColumnName = "id")
    private CatalogDTO catalog;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private StockDTO stock;

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


    public CatalogDTO getCatalog() {
        return this.catalog;
    }

    public void setCatalog(CatalogDTO catalog) {
        this.catalog = catalog;
    }


    public StockDTO getStock() {
        return this.stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }
    
    
}