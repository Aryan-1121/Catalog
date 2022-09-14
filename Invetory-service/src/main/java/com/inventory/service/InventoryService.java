package com.inventory.service;

import com.inventory.bean.InventoryItem;

public interface InventoryService {
	public InventoryItem getItemByProductCode(String code);
	
	public boolean updateQuantityByProductCode(String code, int availableQuantity);

}
