package com.myca.recipebook.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.myca.recipebook.dto.DishDto;
import com.myca.recipebook.dto.IngredientsDto;
import com.myca.recipebook.model.Dish;
import com.myca.recipebook.model.Ingredients;

@Component
public class IngredientsConverter implements Converter<IngredientsDto, Ingredients> {

	@Override
	public Ingredients convert(IngredientsDto source) {
		Ingredients ingredients =new Ingredients();
		
		ingredients.setId(source.getId());
		ingredients.setName(source.getName());
		ingredients.setQty(source.getQty());
		
	
		
		return ingredients;
	}

	



	
}
