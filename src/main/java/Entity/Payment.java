/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.PaymentPage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Payment {
//    private String PaymentId;
//    private String PaymentType;
//    private String PaymentDate;
//    private String PaymentTime;
//    private Float PaymentAmount;
    
//    public void Payment(String paymetnId, String paymentType, String paymentDate, String paymentTime, Float paymentAmount){
//        this.PaymentId = paymetnId;
//        this.PaymentType = paymentType;
//        this.PaymentDate = paymentDate;
//        this.PaymentTime = paymentTime;
//        this.PaymentAmount = paymentAmount;
//    }
    
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    PaymentPage.timetxt.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    PaymentPage.datetxt.setText(df.format(date));
                }
            }
        }).start();
    }
}
