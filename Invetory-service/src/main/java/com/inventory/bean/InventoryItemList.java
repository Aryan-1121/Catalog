package com.inventory.bean;
import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemList {

	private List<InventoryItem> inventoryItems;
}
