package com.catalog.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.catalog.bean.ProductCatalog;

import java.util.Optional;


@Repository
public interface ProductDao extends JpaRepository<ProductCatalog, Integer>{
	@Query(value="from ProductCatalog where code=:productCode")
	ProductCatalog findByCode(String productCode);
	
}