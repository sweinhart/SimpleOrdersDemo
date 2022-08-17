package com.example.SimpleOrdersDemo.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderBasket {

	List<OrderItem> orderBasket = new ArrayList<>();

	public List<OrderItem> getOrderBasket() {
		return orderBasket;
	}

	public void setOrderBasket(List<OrderItem> orderBasket) {
		this.orderBasket = orderBasket;
	}
	
}
