package com.oc_p8.ecommerce.ecommerce.infrastructure.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "catalog")
@Table(name = "catalogs")
public class CatalogDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "catalog")
    private ShopDto shop;

    @OneToMany(mappedBy = "catalog", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CatalogItemDTO> items;

    public CatalogDTO() {
        this.items = new ArrayList<>();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ShopDto getShop() {
        return this.shop;
    }

    public void setShop(ShopDto shop) {
        this.shop = shop;
    }


    public List<CatalogItemDTO> getItems() {
        return this.items;
    }

    public void setItems(List<CatalogItemDTO> items) {
        this.items = items;
    }


}
