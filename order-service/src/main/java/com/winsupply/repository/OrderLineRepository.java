package com.winsupply.repository;

import com.winsupply.entity.Order;
import com.winsupply.entity.OrderLines;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLines, Integer>  {

    List<OrderLines> findByOrder(Order order);
}
