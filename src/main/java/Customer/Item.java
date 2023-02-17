/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author Kenny
 */
public class Item {
    private String FoodID;
    private String Foodname;
    private double totalPrice;
    private int qty;
    
    public Item(String name, int qty, double unitPrice){
//        this.FoodID = ID;
        this.Foodname = name;
        this.qty = qty;
        totalPrice = qty*unitPrice;
}
    
    public void setName(String name){
        this.Foodname = name;
    }
    
    public String getName() {
        return Foodname;
    }
    
    public void setTotalPrice (double totalPrice){
        this.totalPrice = totalPrice;
    }
    
    public double getTotalPrice (){
        return totalPrice;
    }
    
    public void setQty(int qty){
        this.qty = qty;
    }
}


