package com.example.SimpleOrdersDemo.dto;

import org.junit.jupiter.api.Test;

public class OrderItemTest {

	@Test
	public void testOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct("apples");
		orderItem.setQuantity(10);
		assert(orderItem.getProduct().equals("apples"));
		assert(orderItem.getQuantity().equals(10));
	}
}
