package com.example.SimpleOrdersDemo.dto;

import org.junit.jupiter.api.Test;

public class InventoryTest {
	
	Inventory inventory = Inventory.getInstance();

	@Test
	public void testInventory() {
		Product apples = inventory.getProduct("apples");
		Product oranges = inventory.getProduct("oranges");
		assert(apples.getProductName().equals("apples"));
		assert(apples.getId().equals(Long.valueOf(1)));
		assert(apples.getPrice().equals(0.6));
		assert(oranges.getId().equals(Long.valueOf(2)));
		assert(oranges.getProductName().equals("oranges"));
		assert(oranges.getPrice().equals(.25));
	}
}
