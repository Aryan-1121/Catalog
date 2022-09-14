package com.catalog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.bean.ProductCatalog;
import com.catalog.service.ProductServiceImpl;

@RestController
public class ProductResource {

	@Autowired
	private ProductServiceImpl catalogService;
	
	@GetMapping(path = "/products",produces = MediaType.APPLICATION_JSON_VALUE )
	public List<ProductCatalog> listAllProducts(){
		return catalogService.listAllProducts();
		
	}
	
	@GetMapping(path = "/products/code/{productCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductCatalog getProductByCode(@PathVariable("productCode") String productCode){
		return catalogService.getProductByCode(productCode);
		
	}


}