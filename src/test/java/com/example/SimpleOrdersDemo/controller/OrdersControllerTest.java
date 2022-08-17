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
	OrderBasket orderBasket = new OrderBasket();
	OrderItemTotal orderItemTotal = new OrderItemTotal();
	OrderItem orderItem = new OrderItem();
	
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
	
	@Test
	public void getOrderById() {
		OrderSummary orderSummary = new OrderSummary();
		orderSummary.setOrderId(1);
		orderSummary.setTotalPrice(5.0);
		List<OrderItemTotal> items = new ArrayList<>();
		orderSummary.setOrderSummary(items);
		when(orderService.getCompletedOrderById(1)).thenReturn(orderSummary);
		ResponseEntity<OrderSummary> response = ordersController.getOrderById(1);
		assert(response.getBody().getTotalPrice().equals("5.00"));
		assert(response.getBody().getOrderId() == 1);
	}
	
	@Test
	public void getAllOrders() {
		List<OrderSummary> orders = new ArrayList<>();
		OrderSummary orderSummary = new OrderSummary();
		orderSummary.setOrderId(1);
		orderSummary.setTotalPrice(5.0);
		List<OrderItemTotal> items = new ArrayList<>();
		orderSummary.setOrderSummary(items);
		orders.add(orderSummary);
		orderSummary = new OrderSummary();
		orderSummary.setOrderId(2);
		orderSummary.setTotalPrice(10.0);
		items = new ArrayList<>();
		orderSummary.setOrderSummary(items);
		orders.add(orderSummary);
		when(orderService.getAllCompletedOrders()).thenReturn(orders);
		ResponseEntity<List<OrderSummary>> response = ordersController.getAllCompletedOrders();
		assert(response.getBody().size() == 2);
	}
}
