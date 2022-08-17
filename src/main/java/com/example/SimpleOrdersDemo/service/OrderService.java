package com.example.SimpleOrdersDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SimpleOrdersDemo.dto.Inventory;
import com.example.SimpleOrdersDemo.dto.OrderBasket;
import com.example.SimpleOrdersDemo.dto.OrderItem;
import com.example.SimpleOrdersDemo.dto.OrderItemTotal;
import com.example.SimpleOrdersDemo.dto.OrderSummary;
import com.example.SimpleOrdersDemo.dto.Product;

@Service
public class OrderService {
	List<OrderItem> orderList = new ArrayList<>();

	public OrderSummary createOrderSummary(OrderBasket order) {
		OrderSummary orderSummary = new OrderSummary();
		for (OrderItem item : order.getOrderBasket()) {
			OrderItemTotal itemTotal = new OrderItemTotal();
			Product product = Inventory.getInstance().getProduct(item.getProduct());
			itemTotal.setProduct(product);
			itemTotal.setQuantity(item.getQuantity());
			orderSummary.getOrderSummary().add(itemTotal);
		}
		orderSummary.calculateTotalPriceV2();
		return orderSummary;
	}
}
