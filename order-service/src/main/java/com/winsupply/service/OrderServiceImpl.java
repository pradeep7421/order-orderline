package com.winsupply.service;

import com.winsupply.entity.Order;
import com.winsupply.entity.OrderLines;
import com.winsupply.model.OrderLinesRequest;
import com.winsupply.model.OrderRequest;
import com.winsupply.repository.OrderLineRepository;
import com.winsupply.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;

    public OrderServiceImpl(OrderRepository orderRepository,OrderLineRepository orderLineRepository) {
        this.orderRepository = orderRepository;
        this.orderLineRepository=orderLineRepository;
        
        
    }

    public Order createOrder(OrderRequest orderRequest) {
       Order order=new Order();
       

        System.out.println("from service"+ orderRequest);
        order.setOrderAmount(orderRequest.getOrderAmount());
        
        order.setOrderName(orderRequest.getOrderName());
            
        
        List<OrderLines> orderLinesList = new ArrayList<>();

        for (OrderLinesRequest orderLinesRequest : orderRequest.getOrderLinesRequestList()) {

             OrderLines orderLines= new OrderLines();

            orderLines.setQuantity(orderLinesRequest.getQuantity());
            orderLines.setItemName(orderLinesRequest.getItemName());
            orderLines.setOrder(order); 

            orderLinesList.add(orderLines);
            
        }
        order.setOrderLinesList(orderLinesList);

       Order saveorder = orderRepository.save(order);
       for(OrderLines orderLines:orderLinesList) {
           orderLines.setOrder(saveorder);
       }
       orderLineRepository.saveAll(orderLinesList);

       return saveorder;
    }

    @Override
    public Order getOrderDetails(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            List<OrderLines> orderLinesList = orderLineRepository.findByOrder(order);

            order.setOrderLinesList(orderLinesList);

            return order;
        }

        return null;
    }



}
