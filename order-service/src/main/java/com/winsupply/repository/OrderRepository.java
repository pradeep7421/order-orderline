package com.winsupply.repository;

import com.winsupply.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
