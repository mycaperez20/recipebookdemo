package com.myca.recipebook.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myca.recipebook.dto.IngredientsDto;
import com.myca.recipebook.model.Ingredients;

@Component
public class IngredientsDtoConverter implements Converter<Ingredients, IngredientsDto> {

	@Override
	public IngredientsDto convert(Ingredients source) {
		IngredientsDto ingredientsDto = new IngredientsDto();
		
		ingredientsDto.setId(source.getId());
		ingredientsDto.setName(source.getName());
		ingredientsDto.setQty(source.getQty());
		
		return ingredientsDto;
	}


	

}
