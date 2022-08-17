package com.example.SimpleOrdersDemo.dto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderSummaryTest {

	Inventory inventory = Inventory.getInstance();
	OrderItemTotal orderItemTotal = null;
	OrderSummary orderSummary = null;
	List<OrderItemTotal> basket = null;
	
	@BeforeEach
	public void init() {
		orderItemTotal = new OrderItemTotal();
		orderSummary = new OrderSummary();
		basket = new ArrayList<>();
	}
	
	@Test
	public void testOrderSummaryApples() {
		Product apples = inventory.getProduct("apples");
		orderItemTotal.setProduct(apples);
		orderItemTotal.setQuantity(35);
		basket.add(orderItemTotal);
		orderSummary.setOrderSummary(basket);
		orderSummary.calculateTotalPriceV2();
		String totalPrice = orderSummary.getTotalPrice();
		assert(totalPrice.equals("10.80"));
	}
	
	@Test
	public void testOrderSummaryOranges() {
		Product oranges = inventory.getProduct("oranges");
		orderItemTotal.setProduct(oranges);
		orderItemTotal.setQuantity(35);
		basket.add(orderItemTotal);
		orderSummary.setOrderSummary(basket);
		orderSummary.calculateTotalPriceV2();
		String totalPrice = orderSummary.getTotalPrice();
		System.out.println(totalPrice);
		assert(totalPrice.equals("6.00"));
	}
}
