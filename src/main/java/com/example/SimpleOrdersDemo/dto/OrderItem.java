package com.example.SimpleOrdersDemo.dto;


public class OrderItem {

	String product;
	Integer quantity;
	
	public OrderItem() {
		super();
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
