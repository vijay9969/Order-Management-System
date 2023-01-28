package com.orders.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orders.model.Customer;
import com.orders.model.Orders;
import com.orders.model.Product;
import com.orders.repository.CustomerRepository;
import com.orders.repository.OrderRepository;
import com.orders.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service
public class OrderService {
	
	 	private final CustomerRepository customerRepository;
	    private final ProductRepository productRepository;
	    private final OrderRepository orderRepository;

	    public Iterable<Customer> findAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public List<Product> findAllProducts() {
	        return productRepository.findAll();
	    }

	    public List<Orders> findAllOrders() {
	        return orderRepository.findAll();
	    }

}
