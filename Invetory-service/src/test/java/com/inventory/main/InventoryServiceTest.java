package com.inventory.main;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventory.bean.InventoryItem;
import com.inventory.bean.InventoryItemList;
import com.inventory.persistence.InventoryDao;
import com.inventory.service.InventoryServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class InventoryServiceTest {

	@Autowired
	@InjectMocks
	private InventoryServiceImpl inventoryService;
	
	@Autowired
	@Mock
	private InventoryDao inventoryDao;
	private AutoCloseable closeable;

	
	private InventoryItemList inventoryItemList ;
	
	@BeforeEach
	public void initialize() throws Exception {
		
		List<InventoryItem> items = new ArrayList<InventoryItem>();
		items.add(new InventoryItem(1, "PRO01", 100));
		items.add(new InventoryItem(2, "PRO02", 100));
		items.add(new InventoryItem(3, "PRO03", 100));
		items.add(new InventoryItem(4, "PRO04", 100));

		closeable=MockitoAnnotations.openMocks(this);

		inventoryItemList = new InventoryItemList(items);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		inventoryItemList = null;
		closeable.close();
	}
	
	
	@Test
	void testGetItemByProductCode() {
		Mockito.when(inventoryDao.findByCode("PRO01")).thenReturn(inventoryItemList.getInventoryItems().get(0));
		assertEquals(inventoryItemList.getInventoryItems().get(0), inventoryService.getItemByProductCode("PRO01"));
	}

	
	@Test
	void testGetItemByProductCodeNegative() {
		Mockito.when(inventoryDao.findByCode("PRO05")).thenReturn(null);
		assertEquals(null, inventoryService.getItemByProductCode("PRO05"));
	}
	@Test
	void testUpdateQuantityByProductCodePositive() {
		Mockito.when(inventoryDao.updateRecord("PRO01", 1000)).thenReturn(1);
		assertTrue(inventoryService.updateQuantityByProductCode("PRO01", 1000));
	}
	
	@Test
	void testUpdateQuantityByProductCodeNegativequantity() {
		Mockito.when(inventoryDao.updateRecord("PRO01", -100)).thenReturn(0);
		assertFalse(inventoryService.updateQuantityByProductCode("PRO01", -100));
	}
	
	@Test
	void testUpdateQuantityByProductCodeProductNotInList() {
		Mockito.when(inventoryDao.updateRecord("PRO05", 1000)).thenReturn(0);
		assertFalse(inventoryService.updateQuantityByProductCode("PRO05", 1000));
	}
	
	@Test
	void testUpdateQuantityByProductCodeInvalidQtyProductNotInList() {
		Mockito.when(inventoryDao.updateRecord("PRO05", -10)).thenReturn(0);
		assertFalse(inventoryService.updateQuantityByProductCode("PRO05", -10));
	}

}
