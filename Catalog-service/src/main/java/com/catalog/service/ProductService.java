package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.catalog.bean.ProductCatalog;

@Service
public interface ProductService {

	List<ProductCatalog> listAllProducts();
	ProductCatalog getProductByCode(String code);
}