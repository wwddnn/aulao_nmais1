package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;

	//the class Product does have a list of categories, so in the request of Postman the object product is nested with categories
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, List<CategoryDTO> categories) {
		super();
		this.id = id;
		this.name = name;
		this.categories = categories;
	}

	//copy 'id', 'name' and 'list of categories' entity product to ProductDTO
	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		categories = product.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
}
