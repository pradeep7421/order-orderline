package com.winsupply.controller;

import com.winsupply.entity.Order;
import com.winsupply.model.OrderRequest;
import com.winsupply.responses.ApiResponse;
import com.winsupply.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {
   
private final OrderService orderService;

   
   
public OrderController(OrderService orderService) {
    
    this.orderService = orderService;
}

@PostMapping("")
public ResponseEntity<ApiResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
    System.out.println("hello");
    Order order = orderService.createOrder(orderRequest);
    System.out.println("my order"+orderRequest);
    if (order != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Order created successfully"));
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "Order creation failed"));
    }
}

@GetMapping("/{orderId}")
public ResponseEntity<Object> getOrderDetails(@PathVariable int orderId) {
    Order order = orderService.getOrderDetails(orderId);
    
    if (order != null) {
        return ResponseEntity.status(HttpStatus.OK).body(order);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Order not found"));
    }
}


    

}
