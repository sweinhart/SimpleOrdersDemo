package com.example.SimpleOrdersDemo.service;

import org.junit.jupiter.api.Test;
import com.example.SimpleOrdersDemo.dto.Inventory;
import com.example.SimpleOrdersDemo.dto.OrderBasket;
import com.example.SimpleOrdersDemo.dto.OrderItem;
import com.example.SimpleOrdersDemo.dto.OrderItemTotal;
import com.example.SimpleOrdersDemo.dto.OrderSummary;

public class OrderServiceTest {
	
	OrderService orderService = new OrderService();
	
	Inventory inventory = Inventory.getInstance();
	
	OrderBasket orderBasket = new OrderBasket();
	OrderItemTotal orderItemTotal = new OrderItemTotal();
	OrderItem orderItem = new OrderItem();
	
	@Test
	public void createOrderSummaryTest() {
		orderItem.setProduct("apples");
		orderItem.setQuantity(10);
		orderBasket.getOrderBasket().add(orderItem);
		OrderSummary summary = orderService.createOrderSummary(orderBasket);
		assert(summary.getTotalPrice().equals("6.00"));
	}
}
