/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.OrderPage;
import static Customer.OrderPage.backend;
import static Customer.OrderPage.receipt;
import static Customer.OrderPage.total;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Cart extends Receipt {
//    private Integer cartID;
//    private Food food;
//    private Integer quantity;
//    
//    public void Cart(Integer cartId, Food food, Integer qty){
//        this.cartID = cartId;
//        this.food = food;
//        this.quantity = qty;
//    }
    
    public void cart (){
    try{
        FileWriter Writercart = new FileWriter("cart.txt", false);
        FileWriter Writerlastpayment = new FileWriter("lastpay.txt", false);
        Writercart.write("Food Cart"+"\n");
        Writercart.write(backend.getText());
        Writercart.close();
        Writerlastpayment.write("Lastpayment"+"\n");
        Writerlastpayment.write(total.getText());
        Writerlastpayment.close();
        SaveReceipt();
        
        }       
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }
    
    
    
    public void end(){
        receipt.append(("**********************Thank you for purchasing**********************\n"
        +"              Delivery Fees:\t\t"+"RM"+OrderPage.subtotal.getText()+"\n"
        +"              Subtotal:\t\t"+"RM"+OrderPage.deliveryfees.getText()+"\n"
        +"              Total Price:\t\t"+"RM"+OrderPage.total.getText()+"\n") 
          
        );
    }
    
    
}
