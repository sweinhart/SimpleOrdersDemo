package com.example.SimpleOrdersDemo.dto;

import org.junit.jupiter.api.Test;

public class OrderItemTotalTest {

	Inventory inventory = Inventory.getInstance();
	OrderItemTotal orderItemTotal = new OrderItemTotal();
	
	@Test
	public void testOrderItemTotal() {
		Product apples = inventory.getProduct("apples");
		orderItemTotal.setProduct(inventory.getProduct("apples"));
		orderItemTotal.setQuantity(10);
		assert(orderItemTotal.getProduct().equals(apples));
		assert(orderItemTotal.getQuantity().equals(10));
	}
}
