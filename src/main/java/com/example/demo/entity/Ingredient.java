package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "DEMO_INGREDIENT")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INGREDIENT_ID")
	private Integer ingredientId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TACO_ID", nullable = false)
	private Taco taco;
	
	@Column(name = "NAME")
	@SerializedName("name")
	@Expose
	private String name;

	public Ingredient(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	public Taco getTaco() {
		return taco;
	}

	public void setTaco(Taco taco) {
		this.taco = taco;
	}
	
	
	
}
