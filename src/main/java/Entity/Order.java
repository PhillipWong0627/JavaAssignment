/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author user
 */
class Order {
    
    private Integer OrderId;
    private String DateCreated;
    private Customer Customer;
    private String OrderStatus;
    private Payment Payment;
    private ArrayList<OrderDetails> OrderList;
    
    public void Order(Integer orderId, String datecreated, Customer customer,String orderStatus, Payment payment, ArrayList<OrderDetails> orderList){
        this.OrderId = orderId;
        this.DateCreated = datecreated;
        this.Customer = customer;
        this.OrderStatus = orderStatus;
        this.Payment = payment;
        this.OrderList = orderList;
    }
}
