package com.myca.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myca.recipebook.model.Ingredients;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
