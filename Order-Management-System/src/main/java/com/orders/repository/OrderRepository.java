package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
