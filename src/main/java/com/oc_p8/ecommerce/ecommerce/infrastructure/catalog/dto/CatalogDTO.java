package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.dto.ShopDto;


@Entity(name = "catalog")
@Table(name = "catalogs")
public class CatalogDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "catalog")
    private ShopDto shop;


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

}
