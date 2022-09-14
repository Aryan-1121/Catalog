package com.inventory.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.bean.InventoryItem;
import com.inventory.service.InventoryService;

@RestController
public class InventoryResource {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(path = "/code/{productCode}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryItem getInventoryItemByProductCode (@PathVariable("productCode") String code) {
		return inventoryService.getItemByProductCode(code);
	}
	
	@PutMapping(path = "/code/{productCode}/{availableQuantity}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateInventoryItemQuantityByProductCode(@PathVariable("productCode") String productCode, @PathVariable("availableQuantity") int avaialableQuantity) {
		
		return inventoryService.updateQuantityByProductCode(productCode, avaialableQuantity);
	}
}
