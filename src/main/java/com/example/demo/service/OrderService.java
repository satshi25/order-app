package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.ordering.antlr.OrderingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.custom.OrderSpeification;
import com.example.demo.custom.TacoSpecification;
import com.example.demo.entity.Order;
import com.example.demo.entity.Taco;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.TacoRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private TacoRepository tacoRepository;
	
	public List<Order> getOrderDetails() {
		
//		Taco tacoInput = new Taco();
//		tacoInput.setName(name);
//		
//		TacoSpecification tacoFilter = new TacoSpecification(tacoInput);
//		Optional<Taco> tacoResult = tacoRepository.findOne(tacoFilter);
//		
//		
//		
//		Order orderInput = new Order();
//		orderInput.setTacoId(tacoResult.get().getId());
//
//		OrderSpeification orderFilter = new OrderSpeification(orderInput);
//		Optional<Order> orderResult = repository.findOne(orderFilter);
		
		return repository.findAll();
	}

}
