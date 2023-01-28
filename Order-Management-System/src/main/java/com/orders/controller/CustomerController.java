package com.orders.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.model.Customer;
import com.orders.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {
	
	private final CustomerRepository customerRepo;

    @GetMapping("/customers")
    ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>((List<Customer>) customerRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("/customers")
    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
    	customerRepo.deleteById(id);
       
        return "Customer delete successfully..";
    }
}
