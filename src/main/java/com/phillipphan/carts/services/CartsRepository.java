package com.phillipphan.carts.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillipphan.carts.models.Cart;

public interface CartsRepository extends JpaRepository<Cart, Integer>{
    
}
