package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

}
