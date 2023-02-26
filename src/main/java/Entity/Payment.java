/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import static Customer.CustomerLogin.username;
import Customer.PaymentPage;
import static Customer.PaymentPage.datetxt;
import static Customer.PaymentPage.pay;
import static Customer.PaymentPage.timetxt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Payment{
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
    public void ReadUsertoPayment() throws IOException{
        FileWriter Writeruser = new FileWriter("currentuser.txt", false);
        Writeruser.write("Current User"+"\n");
        Writeruser.write(username.getText());
        Writeruser.close();
    }
        
    
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
    
    public void Savemethod(){
            try {
                int num=0;
//                int num1=0;
//                int num2=0;
                File cart = new File("cart.txt");
                FileReader fr = new FileReader(cart);
                BufferedReader brr = new BufferedReader(new FileReader(cart));
                String firstLine = brr.readLine().trim();
                Object[] tableLinescart = brr.lines().toArray();
                for (int z = 0; z < 1 ; z++) {
                    String line1 = tableLinescart[z].toString().trim();
                    System.out.println(line1);
               
               
                        File orderdetail = new File("orderdetail.txt");
                        FileReader tr = new FileReader(orderdetail);
                        BufferedReader br = new BufferedReader(new FileReader(orderdetail));
                        Object[] tableLines = br.lines().toArray();
                        for (int t = 0; t < tableLines.length; t++) {
                            String line = tableLines[t].toString().trim();
                            num++;
                        }
                        
                        File deliverydetail = new File("deliverydetail.txt");
                            FileReader mr = new FileReader(deliverydetail);
                            BufferedReader nr = new BufferedReader(new FileReader(deliverydetail));
//                            Object[] tableLinesdelivery = nr.lines().toArray();
//                            for (int n = 0; n < tableLinesdelivery.length; n++) {
//                            String line2 = tableLines[n].toString().trim();
//                            num1++;
//                                
//                        }
                            
                        File creditcard = new File("creditcarddetail.txt");
                            FileReader frr = new FileReader(creditcard);
                            BufferedReader bread = new BufferedReader(new FileReader(creditcard));
//                            Object[] tableLinescreditcard = nr.lines().toArray();
//                            for (int p = 0; p < tableLinescreditcard.length; p++) {
//                            String line2 = tableLines[p].toString().trim();
//                            num2++;
//                            }
                            
                    FileWriter fww;
                    fww = new FileWriter(creditcard,true);
                    BufferedWriter bww = new BufferedWriter(fww);
                    String ccdetail = "L"+(num+1)+":"+"P"+(num+1)+":"+PaymentPage.ccname.getText()+":"+PaymentPage.ccnumber.getText()+":"+"RM"+PaymentPage.pay.getText()+":"+"\n";
                            
                    FileWriter fw;
                    fw = new FileWriter(deliverydetail,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String something = "L"+(num+1)+":"+"P"+(num+1)+":"+PaymentPage.userhere.getText()+":"+PaymentPage.address.getText()+":"+"PendingAssign"+":"+"PendingAssign"+":"+"-"+"\n";
                        
                        
                    FileWriter FW;
                    FW = new FileWriter(orderdetail,true);
                    BufferedWriter BW = new BufferedWriter(FW);
                    String record = "L"+(num+1)+"?"+datetxt.getText()+"?"+timetxt.getText()+"?"+line1+"\n";
                     
                     
                    
                     bww.write(ccdetail);
                     bww.close();
                     frr.close();
                     BW.write(record);
                     BW.close();
                     FW.close();
                     bw.write(something);
                     bw.close();
                     fw.close();
                    
                    JOptionPane.showMessageDialog(null, "Payment Success"+"\n"+ "Your Order is L"+ (num+1) +". and Your Payment is P"+ (num+1));  
               }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void ReadPrice(){
        try {
            File price = new File("lastpay.txt");
            FileReader tr = new FileReader(price);
            BufferedReader br = new BufferedReader(new FileReader(price));
            String firstLine = br.readLine().trim();
            Object[] tableLines = br.lines().toArray();
            for (int z = 0; z <1; z++) {
                String line = tableLines[z].toString().trim();
                pay.setText(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void ReadReceipt(){
        try {
        File price = new File("receipt.txt");
        BufferedReader br = new BufferedReader(new FileReader(price));
        
        String line;
        while ((line = br.readLine()) != null) {
            PaymentPage.textarea.append(line + "\n");
        }
        
        br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ReadCurrentUser(){
        try {
            File price = new File("currentuser.txt");
            FileReader tr = new FileReader(price);
            BufferedReader br = new BufferedReader(new FileReader(price));
            String firstLine = br.readLine().trim();
            Object[] tableLines = br.lines().toArray();
            for (int z = 0; z <1; z++) {
                String line = tableLines[z].toString().trim();
                PaymentPage.userhere.setText(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
