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

import com.oc_p8.ecommerce.ecommerce.infrastructure.adapters.StockItemDTO;

@Entity(name = "stock")
@Table(name = "stocks")
public class StockDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "stock")
    private ShopDto shop;

    @OneToMany(mappedBy = "stock", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<StockItemDTO> items;

    public StockDTO() {
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


    public List<StockItemDTO> getItems() {
        return this.items;
    }

    public void setItems(List<StockItemDTO> items) {
        this.items = items;
    }

}
