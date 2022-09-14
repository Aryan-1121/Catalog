package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.bean.InventoryItem;
import com.inventory.persistence.InventoryDao;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public InventoryItem getItemByProductCode(String code) {
		// TODO Auto-generated method stub
		InventoryItem item = inventoryDao.findByCode(code);
		return item;
	}

	@Override
	public boolean updateQuantityByProductCode(String code, int availableQuantity) {
		if (availableQuantity < 0)
			return false ;
		if(getItemByProductCode(code) == null) {
			
			int rows = inventoryDao.updateRecord(code, availableQuantity);
		if (rows>0)
			return true;		
		}
		
		return false;
	}

	
}
