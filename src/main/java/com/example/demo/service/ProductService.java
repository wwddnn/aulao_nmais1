package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	//findAll method
	//PageRequest return page object
	//obs. List don't is a String in Java 8, so have to use stream().map()
	//Page is a String in Java 8, so don't have to use stream(), only use map()
	@Transactional(readOnly = true)
	public Page<ProductDTO> find(PageRequest pageRequest) {
		Page<Product> page = repository.findAll(pageRequest);
		//map of identity, don't search in database same object in more than 1 context. cache in memory the objects, enjoying JPA ORM
		repository.findProductsCategories(page.stream().collect(Collectors.toList()));
		return page.map(x -> new ProductDTO(x));
	}
}
