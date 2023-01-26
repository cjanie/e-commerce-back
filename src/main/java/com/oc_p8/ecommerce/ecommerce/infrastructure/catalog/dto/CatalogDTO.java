package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "catalog")
@Table(name = "catalogs")
@Data
public class CatalogDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
