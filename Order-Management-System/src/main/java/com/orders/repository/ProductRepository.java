package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
