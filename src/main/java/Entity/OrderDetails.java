/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author user
 */
class OrderDetails {
    private Integer OrderId;
    private Food Food;
    private String Quantity;
    private String OrderStatus;
    
    public void OrderDetails(Integer orderId, Food food, String quantity, String orderStatus){
        this.OrderId = orderId;
        this.Food = food;
        this.Quantity = quantity;
        this.OrderStatus = orderStatus;
        
    }
    
}
