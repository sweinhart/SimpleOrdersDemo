package com.example.SimpleOrdersDemo.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary {

	List<OrderItemTotal> orderSummary = new ArrayList<>();
	Double totalPrice = 0.0;
	Inventory inventory = Inventory.getInstance();
	
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
		return String.valueOf(String.format("%.2f", totalPrice));
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void calculateTotalPrice() {
		for (OrderItemTotal item : orderSummary) {
			totalPrice += item.getProduct().getPrice() * item.getQuantity();
		}
	}
	public void calculateTotalPriceV2() {
		List<OrderItemTotal> apples = new ArrayList();
		List<OrderItemTotal> oranges = new ArrayList();
		for (OrderItemTotal item : orderSummary) {
			if (item.getProduct().getProductName().equals("apples"))
				apples.add(item);
			else if (item.getProduct().getProductName().equals("oranges"))
				oranges.add(item);
		}
		totalPrice += getSpecialApplePrices(apples);
		totalPrice += getSpecialOrangePrices(oranges);
	}
	private Double getSpecialOrangePrices(List<OrderItemTotal> oranges) {
		if (oranges.size() == 0)
			return 0.0;
		Integer quantity = 0;
		Product orange = inventory.getProduct("oranges");
		Double specialPrice = orange.getPrice() * 2;
		for (OrderItemTotal items : oranges) {
			quantity += items.getQuantity();
		}
		Integer adjustedCalculation = quantity / 3;
		Integer remainder = quantity % 3;
		return (adjustedCalculation * specialPrice) + remainder * orange.getPrice();
	}
	private Double getSpecialApplePrices(List<OrderItemTotal> apples) {
		if (apples.size() == 0)
			return 0.0;
		Integer quantity = 0;
		Product apple = inventory.getProduct("apples");
		for (OrderItemTotal items : apples) {
			quantity += items.getQuantity();
		}
		Integer adjustedCalculation = quantity / 2;
		Integer remainder = quantity % 2;
		return (adjustedCalculation * apple.getPrice() + remainder * apple.getPrice());
	}
	
	
}
