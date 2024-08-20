package com.phillipphan.carts.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillipphan.carts.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{
    
}
