package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.custom.ValidIngredientsCount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "DEMO_TACO")
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TACO_ID")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private Order oder; 
	
	@NotEmpty(message = "name should not be null")
	@Size(min = 5, message = "name should not be less that 5 characters")
	@Column(name = "NAME")
	@SerializedName("name")
	@Expose
	private String name;
	
	@ValidIngredientsCount(message = "taco should have at least 1 ingredient")
	@OneToMany(mappedBy = "taco", cascade = {
	        CascadeType.ALL
	    }, orphanRemoval = true)
	@SerializedName("ingredients")
	@Expose
	private Set<Ingredient> ingredients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Order getOder() {
		return oder;
	}

	public void setOder(Order oder) {
		this.oder = oder;
	}


}
