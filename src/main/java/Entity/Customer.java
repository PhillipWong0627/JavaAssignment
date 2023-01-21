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
public class Customer {
    private String customerName;
    private String customerAddress;
    private String Email;
    private Integer creditCardNo;
    private ArrayList<Cart> carList;
    
    public void Customer (String custName, String custAddress, String email,Integer creditCardNo, ArrayList<Cart> cartList){
        this.customerName = custName;
        this.customerAddress = custAddress;
        this.Email = email;
        this.creditCardNo = creditCardNo;
        this.carList = cartList;
    }
    
}
