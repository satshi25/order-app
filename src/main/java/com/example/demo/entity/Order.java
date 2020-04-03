package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "DEMO_ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Integer orderId;

	@OneToMany(mappedBy = "id",cascade = {
	        CascadeType.ALL
	    }, orphanRemoval = true)
	 private List<Taco> taco;
	
	@Transient
	private Integer tacoId;
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	


	public List<Taco> getTaco() {
		return taco;
	}

	public void setTaco(List<Taco> taco) {
		this.taco = taco;
	}

	public Integer getTacoId() {
		return tacoId;
	}

	public void setTacoId(Integer tacoId) {
		this.tacoId = tacoId;
	}
	
	
}
