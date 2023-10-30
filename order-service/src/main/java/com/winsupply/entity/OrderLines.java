package com.winsupply.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_line_Id")
    private int orderLineId;

    @Column(name="quantity")
    private int quantity;

    @Column(name="item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }


    public int getOrderlineId() {
        return orderLineId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderLineId = orderlineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderLines(int quantity, String itemName, Order order) {
        super();
        this.quantity = quantity;
        this.itemName = itemName;
        this.order = order;
    }
    

    public OrderLines() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "OrderLines [orderLineId=" + orderLineId + ", quantity=" + quantity + ", itemName=" + itemName + ", order=" + order + "]";
    }
    
    

}
