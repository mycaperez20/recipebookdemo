package com.myca.recipebook.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class DishDto {

	private Integer id;
	
	@NotEmpty(message = "dish name is empty")
	private String dishName;
	List<IngredientsDto> ingredients;
	
	public DishDto() {}
	
	public DishDto(Integer id, String dishName, List<IngredientsDto> ingredients) {
		this.id = id;
		this.dishName = dishName;
		this.ingredients = ingredients;
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
	public List<IngredientsDto> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<IngredientsDto> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}
