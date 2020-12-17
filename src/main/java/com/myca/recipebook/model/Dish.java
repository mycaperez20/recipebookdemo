package com.myca.recipebook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="dish")

public class Dish {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="dishName" )
	private String dishName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dish_id")
	Set<Ingredients> ingredients = new HashSet<>();

	public Dish() {
		
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDishName() {
		return dishName;
	}


	public void setDishName(String dishName) {
		this.dishName = dishName;
	}


	public Set<Ingredients> getIngredients() {
		return ingredients;
	}


	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		return "Dish [id=" + id + ", dishName=" + dishName + ", ingredients=" + ingredients + "]";
	}
	
	
	
	
}