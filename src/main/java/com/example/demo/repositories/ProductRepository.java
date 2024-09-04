package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    //JOIN FETCH is used to access class Category direct from class Product. go to database one time only.
    //'Pageable pageable' accepted Page, but accepted List
    //JOIN FETCH doesn't do pageable
    //IN is a page, because to does interval between product ids.
    @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products ")
    List<Product> findProductsCategories(List<Product> products);


}
