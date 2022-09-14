package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.bean.ProductCatalog;
import com.catalog.persistance.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	

		@Autowired
		private ProductDao productCatalogDao;
		@Override
		public List<ProductCatalog> listAllProducts() {
			return productCatalogDao.findAll();
		}

		@Override
		public ProductCatalog getProductByCode(String code) {
			// TODO Auto-generated method stub
			return productCatalogDao.findByCode(code);
		}

	
}
