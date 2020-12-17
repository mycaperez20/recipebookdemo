package com.myca.recipebook.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myca.recipebook.dto.IngredientsDto;
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
