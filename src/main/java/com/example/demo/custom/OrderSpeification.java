package com.example.demo.custom;

import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.Order;

public class OrderSpeification implements Specification<Order> {

	private static final long serialVersionUID = 1L;
	Order orderFilter;
	
	public OrderSpeification(Order filter) {
		this.orderFilter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate p = criteriaBuilder.disjunction();
		
		if(Objects.nonNull(orderFilter.getTacoId())) {
			p.getExpressions().add(criteriaBuilder.equal(root.get("taco"), orderFilter.getTacoId()));
		}
		
		return p;
	}

}
