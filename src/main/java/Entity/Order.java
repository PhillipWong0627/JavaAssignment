/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.OrderPage;
import static Customer.OrderPage.datetxt;
import static Customer.OrderPage.timetxt;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Order {

    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    OrderPage.timetxt.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    OrderPage.datetxt.setText(df.format(date));
                }
            }
        }).start();
    }
    
    public void PKFC() throws IOException{
        OrderPage.receipt.setText("**********************Philip & Kenny Food Centre**********************\n"
        +"              Time: "+timetxt.getText()+"          Date: "+datetxt.getText()+"\n"
        +"**************************************************************************"+"\n"
        +"FoodID:\t"+"Item Name:\t\t"+"Price($)\n"
        );
        
    }
    
    
}

//class order {

//    private Integer OrderId;
//    private String DateCreated;
//    private Customer Customer;
//    private String OrderStatus;
//    private Payment Payment;
//    private ArrayList<OrderDetails> OrderList;
//
//    public void Order(Integer orderId, String datecreated, Customer customer, String orderStatus, Payment payment, ArrayList<OrderDetails> orderList) {
//        this.OrderId = orderId;
//        this.DateCreated = datecreated;
//        this.Customer = customer;
//        this.OrderStatus = orderStatus;
//        this.Payment = payment;
//        this.OrderList = orderList;
//    }
//}
