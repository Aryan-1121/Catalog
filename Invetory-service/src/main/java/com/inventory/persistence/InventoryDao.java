package com.inventory.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.bean.InventoryItem;

import java.util.Optional;

import javax.transaction.Transactional;

@Repository
public interface InventoryDao extends JpaRepository<InventoryItem, Long>{

	@Query(value="from InventoryItem where productCode=:productCode")
	InventoryItem findByCode(String productCode);
	
	
	@Modifying
	@Transactional
	@Query(value="update InventoryItem set availableQuantity=:quantity where productCode=:code",nativeQuery = true)
	int updateRecord(@Param("code") String code ,@Param("quantity") int  quantity );
}

