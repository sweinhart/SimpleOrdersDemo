package com.example.SimpleOrdersDemo.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary {

	List<OrderItemTotal> orderSummary = new ArrayList<>();
	Double totalPrice = 0.0;	
	
	public OrderSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<OrderItemTotal> getOrderSummary() {
		return orderSummary;
	}
	public void setOrderSummary(List<OrderItemTotal> orderSummary) {
		this.orderSummary = orderSummary;
	}
	public String getTotalPrice() {
		return totalPrice.toString();
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void calculateTotalPrice() {
		for (OrderItemTotal item : orderSummary) {
			totalPrice += item.getProduct().getPrice() * item.getQuantity();
		}
	}
	
	
}
