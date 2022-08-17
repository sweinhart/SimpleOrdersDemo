package com.example.SimpleOrdersDemo.dto;

import org.junit.jupiter.api.Test;

public class ProductTest {
	
	Inventory inventory = Inventory.getInstance();

	@Test
	public void testProduct() {
		Product product = inventory.getProduct("apples");
		assert(product.getId().equals(Long.valueOf(1)));
		assert(product.getProductName().equals("apples"));
		assert(product.getPrice().equals(0.6));
	}
}
