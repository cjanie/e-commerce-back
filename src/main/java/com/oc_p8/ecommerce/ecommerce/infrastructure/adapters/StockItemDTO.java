package com.oc_p8.ecommerce.ecommerce.infrastructure.adapters;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.ItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.StockDTO;

@Entity(name = "stock_item")
@Table(name = "stocks_items")
public class StockItemDTO extends ItemDTO {

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="stock_id")
    private StockDTO stock;

    public StockDTO getStock() {
        return this.stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }
    
}
