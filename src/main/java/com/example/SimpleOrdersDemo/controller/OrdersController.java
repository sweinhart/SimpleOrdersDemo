package com.example.SimpleOrdersDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleOrdersDemo.dto.Inventory;
import com.example.SimpleOrdersDemo.dto.OrderBasket;
import com.example.SimpleOrdersDemo.dto.OrderSummary;
import com.example.SimpleOrdersDemo.service.OrderService;

@RestController
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	Inventory inventory = Inventory.getInstance();
    
    @GetMapping("/")
    public ResponseEntity<Void> getBasePath() {
        return new ResponseEntity("Service is UP and running...", HttpStatus.OK);
    }
    
    @GetMapping("/products")
    public ResponseEntity<Inventory> getProducts(){
    	return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
    }
    
    @PostMapping("/order")
    public ResponseEntity<OrderSummary> placeOrder(@RequestBody OrderBasket order){
    	OrderSummary orderSummary = orderService.createOrderSummary(order);
    	return new ResponseEntity<OrderSummary>(orderSummary, HttpStatus.OK);
    }
}