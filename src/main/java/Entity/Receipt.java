/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import static Customer.OrderPage.receipt;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kenny
 */
public class Receipt {
     public void SaveReceipt() throws IOException{
        FileWriter Writer = new FileWriter("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\receipt\\receipt.txt", false);
        Writer.write(receipt.getText());
        Writer.close();                   
}
}
