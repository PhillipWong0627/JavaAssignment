/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.OrderPage;
import static Customer.OrderPage.backend;
import static Customer.OrderPage.total;
import Customer.PaymentPage;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Cart {
    private Integer cartID;
    private Food food;
    private Integer quantity;
    
    public void Cart(Integer cartId, Food food, Integer qty){
        this.cartID = cartId;
        this.food = food;
        this.quantity = qty;
    }
    
    public void cart(){
    try{
        FileWriter Writercart = new FileWriter("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\cartinfo\\cart.txt", false);
        FileWriter Writerlastpayment = new FileWriter("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\lastpayment\\lastpay.txt", false);
        Writercart.write("Food Cart"+"\n");
        Writercart.write(backend.getText());
        Writercart.close();
        Writerlastpayment.write("Lastpayment"+"\n");
        Writerlastpayment.write(total.getText());
        Writerlastpayment.close();
        }       
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }
    
}
