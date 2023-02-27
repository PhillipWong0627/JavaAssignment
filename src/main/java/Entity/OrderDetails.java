/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Customer.CheckOrderID;
/**
 *
 * @author user
 */
public class OrderDetails {
    private Integer OrderId;
    private Food Food;
    private String OrderStatus;
//    
    public void OrderDetails(Integer orderId, Food food, String orderStatus){
        this.OrderId = orderId;
        this.Food = food;
        this.OrderStatus = orderStatus;
        
    }
        public void deliverychecking(){
//        DefaultTableModel model = (DefaultTableModel) delivery.getModel();
        try {
            File f = new File("deliverydetail.txt");
            String SearchOrder = CheckOrderID.search.getText();
            if (SearchOrder.isEmpty()){
                return;
            }
            Scanner Sc1 = new Scanner(f);
            int Status = 0;
            while (Sc1.hasNextLine()) {
                String Line = Sc1.nextLine();
                System.out.println(Line);
                String[] myArr = Line.split(":");
                if (myArr[0].equals(SearchOrder)) {
                    Status = 1; // String found
                    CheckOrderID.order.setText(myArr[0]);
                    CheckOrderID.payment.setText(myArr[1]);
                    CheckOrderID.userlabel.setText(myArr[2]);
                    CheckOrderID.address.setText(myArr[3]);
                    CheckOrderID.delivery2.setText(myArr[4]);
                    CheckOrderID.status.setText(myArr[5]);
                    CheckOrderID.fedback.setText(myArr[6]);
//                    for(int i=0;i<model.getRowCount();i++){
//                        String tempusername = (String)model.getValueAt(i,0);
//                        if (tempusername.equals(myArr[0])){
//                            delivery.setRowSelectionInterval(i, i);
//                            break;
//                        }
//                    }
                }
            }
            if (Status == 0) {
                 JOptionPane.showMessageDialog(null, "No such orderID");   
            }
        } catch (IOException Ex) {
            // Handle exception
        }
    }
    
        public void paymentchecking(){
        try {
            File g = new File("creditcarddetail.txt");
            String SearchOrder = CheckOrderID.search.getText();
            if (SearchOrder.isEmpty()){
                return;
            }
            Scanner Sc1 = new Scanner(g);
            while (Sc1.hasNextLine()) {
                String Line = Sc1.nextLine();
                System.out.println(Line);
                String[] myArr = Line.split(":");
                if (myArr[0].equals(SearchOrder)) {
                    CheckOrderID.order1.setText(myArr[0]);
                    CheckOrderID.payment1.setText(myArr[1]);
                    CheckOrderID.ccname.setText(myArr[2]);
                    CheckOrderID.ccnumber.setText(myArr[3]);
                    CheckOrderID.total.setText(myArr[4]);
                }
            }
            
        } catch (IOException Ex) {
            // Handle exception
        }
    }
}
