package com.example.SimpleOrdersDemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SimpleOrdersDemo.dto.Inventory;
import com.example.SimpleOrdersDemo.dto.OrderBasket;
import com.example.SimpleOrdersDemo.dto.OrderItem;
import com.example.SimpleOrdersDemo.dto.OrderItemTotal;
import com.example.SimpleOrdersDemo.dto.OrderSummary;
import com.example.SimpleOrdersDemo.dto.Product;

@Service
public class OrderService {
	
	Integer newOrderId = 1;
	Map<Integer, OrderSummary> completedOrdersMap = new HashMap<>();

	public OrderSummary createOrderSummary(OrderBasket order) {
		OrderSummary orderSummary = new OrderSummary();
		orderSummary.setOrderId(newOrderId);
		newOrderId++;
		for (OrderItem item : order.getOrderBasket()) {
			OrderItemTotal itemTotal = new OrderItemTotal();
			Product product = Inventory.getInstance().getProduct(item.getProduct());
			itemTotal.setProduct(product);
			itemTotal.setQuantity(item.getQuantity());
			orderSummary.getOrderSummary().add(itemTotal);
		}
		orderSummary.calculateTotalPriceV2();
		completedOrdersMap.put(orderSummary.getOrderId(), orderSummary);
		return orderSummary;
	}

	public List<OrderSummary> getAllCompletedOrders(){
		List<OrderSummary> completedOrders = new ArrayList<>();
		for (Integer orderId : completedOrdersMap.keySet()) {
			completedOrders.add(completedOrdersMap.get(orderId));
		}
		return completedOrders;
	}
	
	public OrderSummary getCompletedOrderById(Integer id) {
		return completedOrdersMap.get(id);
	}
}
