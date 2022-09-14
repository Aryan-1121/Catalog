package com.catalog.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductCatalog{

	@Id
    private int id; 
    private String code;
    private String name;
    private String description;
    private double price;

}