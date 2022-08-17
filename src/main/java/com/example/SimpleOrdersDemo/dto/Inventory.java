package com.example.SimpleOrdersDemo.dto;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	static Map<String, Product> products = new HashMap<>();
	static Inventory inventory = null;
	
	private Inventory() {
		initializeSimulatedDbData();
	}
	
	public static Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}
	
	private static void initializeSimulatedDbData() {
		// This code only used because actual database not in use for this demo
		Product apples = new Product();
		Product oranges = new Product();
		apples.setId(Long.valueOf(001));
		apples.setProductName("apples");
		apples.setPrice(.6);
		products.put("apples", apples);
		oranges.setId(Long.valueOf(002));
		oranges.setProductName("oranges");
		oranges.setPrice(.25);
		products.put("oranges", oranges);
	}

	public Map<String, Product> getProducts() {
		return products;
	}
	
	public Product getProduct(String name) {
		return products.get(name);
	}
	
}
