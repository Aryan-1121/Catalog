package com.example.demo;
import java.util.List;

import com.example.bean.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {

	private List<Product> productCatalogList;
}