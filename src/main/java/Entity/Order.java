/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.OrderPage;
import static Customer.OrderPage.backend;
import static Customer.OrderPage.datetxt;
import static Customer.OrderPage.receipt;
import static Customer.OrderPage.timetxt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author user
 */
public class Order{
int x = 0;
   
private static final DecimalFormat decformat =new DecimalFormat("0.00");

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

    
    public void PKFC(){
        OrderPage.receipt.setText("**********************Philip & Kenny Food Centre**********************\n"
        +"              Time: "+timetxt.getText()+"          Date: "+datetxt.getText()+"\n"
        +"**************************************************************************"+"\n"
        +"FoodID:\t"+"Item Name:\t\t"+"Price($)\n"
        );
        
    }
    
    
    
    public void ReadFileAndPrompt() throws FileNotFoundException, IOException {
        x++;
        String add = OrderPage.addtxt.getText();
        if (OrderPage.addtxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You are not adding anything ");
        } else {
            try {
                File fooddata = new File("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\fooddata\\fooddata.txt");
                FileReader tr = new FileReader(fooddata);
                BufferedReader br = new BufferedReader(new FileReader(fooddata));
                Object[] tableLines = br.lines().toArray();
                if (x == 1) {
                    PKFC();
                }
                double subTotal = Double.parseDouble(OrderPage.subtotal.getText());
                double tax = 0.0;
                for (int z = 0; z < tableLines.length; z++) {
                    String line = tableLines[z].toString().trim();
                    String[] dataRow = line.split(",");
                    if (dataRow[0].equals(OrderPage.addtxt.getText())) {
                        receipt.append((dataRow[0] + "\t" + dataRow[1] + "\t\t" + dataRow[2] + "\n"));
                        backend.append(dataRow[0] + "," + dataRow[1] + "," + dataRow[2] + ";");
                        subTotal+= Double.parseDouble(dataRow[2]);
                        if(subTotal<30){
                            tax = subTotal*0.1;
                        }else if(subTotal>30 &&subTotal<=50){
                            tax = subTotal*0.05;
                        }else{
                            tax = 0.00;  
                            
//                            break; 
                        }
                        OrderPage.subtotal.setText(String.valueOf(subTotal));
                        OrderPage.deliveryfees.setText(String.valueOf(decformat.format(tax)));
                        OrderPage.total.setText(String.valueOf(decformat.format(subTotal+tax)));
                        return;
                    }
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Code not found");
            
        }

    }
    

}
