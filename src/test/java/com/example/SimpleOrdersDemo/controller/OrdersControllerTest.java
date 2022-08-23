package com.example.SimpleOrdersDemo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.SimpleOrdersDemo.dto.Inventory;
import com.example.SimpleOrdersDemo.dto.OrderBasket;
import com.example.SimpleOrdersDemo.dto.OrderItem;
import com.example.SimpleOrdersDemo.dto.OrderItemTotal;
import com.example.SimpleOrdersDemo.dto.OrderSummary;
import com.example.SimpleOrdersDemo.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrdersControllerTest {

	@InjectMocks
	OrdersController ordersController;
	
	@Mock
	OrderService orderService;
	
	Inventory inventory = Inventory.getInstance();
	
	@Test
	public void testOrdersController() {
		OrderSummary orderSummary = new OrderSummary();
		OrderItemTotal orderItemTotal = new OrderItemTotal();
		orderItemTotal.setProduct(inventory.getProduct("apples"));
		orderItemTotal.setQuantity(10);
		List<OrderItemTotal> basket = new ArrayList<>();
		basket.add(orderItemTotal);
		orderSummary.setOrderSummary(basket);
		orderSummary.calculateTotalPrice();
		OrderBasket orderBasket = new OrderBasket();
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct("apples");
		orderItem.setQuantity(10);
		orderBasket.getOrderBasket().add(orderItem);
    	when(orderService.createOrderSummary(orderBasket)).thenReturn(orderSummary);
		ResponseEntity<OrderSummary> response = ordersController.placeOrder(orderBasket);
		assert(response.getBody().getTotalPrice().equals("6.00"));
	}
}
