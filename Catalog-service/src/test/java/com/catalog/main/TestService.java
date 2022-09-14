package com.catalog.main;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalog.bean.ProductCatalog;
import com.catalog.bean.ProductList;
import com.catalog.persistance.ProductDao;
import com.catalog.service.ProductServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestService {
	
	@Autowired
	@InjectMocks
	ProductServiceImpl productService;
	
	@Mock
	ProductDao productDao;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	void setUp() throws Exception {
		closeable=MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@Nested
	class TestGetProductsList{
		@Test
		public void getProductsList_T01() {
			List<ProductCatalog> productList=new ArrayList<>();
			productList.add(new ProductCatalog(1,"PRO01","Product1","1st Product",350));
			productList.add(new ProductCatalog(2,"PRO02","Product2","2nd Product",350));
			productList.add(new ProductCatalog(3,"PRO03","Product3","3rd Product",1250));
			productList.add(new ProductCatalog(4,"PRO04","Product4","4th Product",1300));
			
			Mockito.when(productDao.findAll()).thenReturn(productList);
			
//			ProductList expected=new ProductList(productList);
//			assertEquals(expected, productService.listAllProducts());
			assertEquals(productList, productService.listAllProducts());

		}
		
		@Test
		public void getProductsList_T02() {
			List<ProductCatalog> productList=new ArrayList<>();
			
			Mockito.when(productDao.findAll()).thenReturn(productList);
			
//			ProductList expected=new ProductList(productList);
			assertEquals(productList, productService.listAllProducts());
		}
	}
	
	@Nested
	class TestGetProductByCode{
		@Test
		public void getProductByCode_T01() {
			List<ProductCatalog> productList=new ArrayList<>();
			productList.add(new ProductCatalog(1,"PRO01","Product1","1st Product",350));
			Mockito.when(productDao.findByCode("PRO01")).thenReturn(productList.get(0));
			
			ProductCatalog expected=productList.get(0);
			
			assertEquals(expected, productService.getProductByCode("PRO01"));
		}
		
		@Test
		public void getProductByCode_T02() {
			List<ProductCatalog> productList=new ArrayList<>();
			Mockito.when(productDao.findByCode("PRO099")).thenReturn(null);
			
		
			
			assertEquals(null, productService.getProductByCode("PRO099"));
		}
	}
}