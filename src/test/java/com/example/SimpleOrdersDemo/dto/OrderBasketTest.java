package com.example.SimpleOrdersDemo.dto;

import org.junit.jupiter.api.Test;

public class OrderBasketTest {

	@Test
	public void testOrderBasket() {
		OrderBasket orderBasket = new OrderBasket();
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct("apples");
		orderItem.setQuantity(10);
		orderBasket.getOrderBasket().add(orderItem);
		assert(orderBasket.getOrderBasket().get(0).equals(orderItem));
	}
}
