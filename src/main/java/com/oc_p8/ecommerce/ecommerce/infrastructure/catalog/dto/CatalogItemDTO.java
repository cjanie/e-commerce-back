package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "catalog_item")
@Table(name = "catalogs_items")
public class CatalogItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="catalog_id")
    private CatalogDTO catalog;


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

}