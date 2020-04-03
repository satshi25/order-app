package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	
	@Autowired
	private OrderService orderService;

	@GetMapping("/app/order")
	public List<Order> getOrder() {
		return orderService.getOrderDetails();
	}
	
}
