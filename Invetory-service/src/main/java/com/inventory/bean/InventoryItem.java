package com.inventory.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InventoryItem {
	@Id
	private long id;
	private String productCode;
	private int availableQuantity;
}
