package com.example.demo.custom;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Taco;

public class TacoSpecification implements Specification<Taco> {

	private static final long serialVersionUID = 1L;
	Taco tacoFilter;
	
	public TacoSpecification(Taco filter) {
		this.tacoFilter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<Taco> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate p = criteriaBuilder.disjunction();
		
		if(!StringUtils.isEmpty(tacoFilter.getName())) {
			p.getExpressions().add(criteriaBuilder.equal(root.get("name"), tacoFilter.getName()));
		}
		
		return p;
	}

}
