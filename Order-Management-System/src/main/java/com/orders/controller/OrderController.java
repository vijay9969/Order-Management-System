package com.orders.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.model.Orders;
import com.orders.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepo;

    @GetMapping("/orders")
    ResponseEntity<List<Orders>> getOrders(){
        return new ResponseEntity<>(orderRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("/orders")
    ResponseEntity<Orders> saveOrder(@RequestBody Orders orders){
        return new ResponseEntity<>(orderRepo.save(orders), HttpStatus.OK);
    }
}
