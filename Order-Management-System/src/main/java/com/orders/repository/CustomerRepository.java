package com.orders.repository;

import org.springframework.data.repository.CrudRepository;

import com.orders.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
