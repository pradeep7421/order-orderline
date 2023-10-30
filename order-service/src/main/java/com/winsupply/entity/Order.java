package com.winsupply.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * This {@code Order} class represents entity for mapping data into database.
 * 
 * @author PRADEEP
 */

@Entity
@Table(name = "orders")
public class Order {
    /**
     * The identifier generates automatically unique values with auto increment
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    /**
     * The identifier takes values of type double.
     */
    @Column(name = "order_amount")
    private double orderAmount;

    /**
     * The identifier takes values which are strings
     */
    @Column(name = "order_name")
    private String orderName;
    /**
     * The identifier retrieves list of all orderLines from OrderLines entity class
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE,fetch=FetchType.EAGER)
    private List<OrderLines> orderLinesList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public List<OrderLines> getOrderLinesList() {
        return orderLinesList;
    }

    public void setOrderLinesList(List<OrderLines> orderLinesList) {
        this.orderLinesList = orderLinesList;
    }
    

    public Order(double orderAmount, String orderName) {
        super();
        this.orderAmount = orderAmount;
        this.orderName = orderName;
        
    }

    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderName=" + orderName + ", orderLines=" + orderLinesList + "]";
    }

}
