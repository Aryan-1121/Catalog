package com.example.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.bean.Product;
@Repository
public interface CatalogDao extends JpaRepository<Product, Integer>{
	@Query(value="from ProductCatalog where code=:productCode")
	Optional<Product> findByProductCode(String productCode);
	
}