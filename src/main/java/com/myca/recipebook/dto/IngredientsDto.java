package com.myca.recipebook.dto;


public class IngredientsDto {
	
	private Integer id;
	private String name;
	private int qty;
	
	
	
	public IngredientsDto() {
	}
	
	public IngredientsDto(Integer id, String name, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
	}


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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	

}
