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
public class DeliveryStaff {
    private String DeliveryStaffName;
    private ArrayList<Order> DeliveryOrderList;
    
    public void DeliveryStaff(String deliveryStaffName, ArrayList<Order> deliveryOrderList ){
        
        this.DeliveryStaffName = deliveryStaffName;
        this.DeliveryOrderList = deliveryOrderList;
        
        
        
    }
    
}
