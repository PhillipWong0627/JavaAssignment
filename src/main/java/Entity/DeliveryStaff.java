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
public class DeliveryStaff extends User {
    private String DeliveryStaffName;
    private ArrayList<Order> DeliveryOrderList;
    
   

    public DeliveryStaff(String DeliveryStaffName, ArrayList<Order> DeliveryOrderList, String userID, String password, String dateOfBirth, Integer phoneNumber) {
        super(userID, password, dateOfBirth, phoneNumber);
        this.DeliveryStaffName = DeliveryStaffName;
        this.DeliveryOrderList = DeliveryOrderList;
    }
    
    
    
    
    
}
