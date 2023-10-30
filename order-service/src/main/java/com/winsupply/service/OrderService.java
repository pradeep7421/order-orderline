package com.winsupply.service;

import com.winsupply.entity.Order;
import com.winsupply.model.OrderRequest;

public interface OrderService {

    Order createOrder(OrderRequest orderRequest);

    Order getOrderDetails(int orderId);


}
