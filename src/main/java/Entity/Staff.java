/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.CustomerLogin;
import Customer.OrderPage;
import Delivery.DeliveryInterface;
import Delivery.DeliveryUpdateFeedback;
import static Delivery.DeliveryUpdateFeedback.delivery;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Delivery.DeliveryStaffLogin;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kenny
 */
public class Staff {
    
    public boolean login(){
        try {
            File deliverystaff = new File("staffFile.txt");
            FileReader tr = new FileReader(deliverystaff);
            BufferedReader br = new BufferedReader(new FileReader(deliverystaff));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(",");
            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(":");
                System.out.println(dataRow[0]);
                if(DeliveryStaffLogin.username.getText().equals(dataRow[1]) && DeliveryStaffLogin.passf.getText().equals(dataRow[2])){
                    JOptionPane.showMessageDialog(null, "Welcome, " +DeliveryStaffLogin.username.getText());
                    DeliveryInterface di = new DeliveryInterface();
                    di.setVisible(true);
                    FileWriter Writer = new FileWriter("loginactivity.txt", true);
                    Writer.write("DeliveryStaff"+"/"+DeliveryStaffLogin.username.getText()+"/"+DeliveryStaffLogin.datetxt.getText()+"/"+DeliveryStaffLogin.timetxt.getText()+"\n");
                    Writer.close();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DeliveryStaffLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void DeliveryDetailsTable() {
        try {
            File deliverydetail = new File("deliverydetail.txt");
            FileReader tr = new FileReader(deliverydetail);
            BufferedReader br = new BufferedReader(new FileReader(deliverydetail));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(":");
            DefaultTableModel model = (DefaultTableModel) DeliveryUpdateFeedback.delivery.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(":");
                model.addRow(dataRow);

            }

        } catch (IOException ex) {
            Logger.getLogger(DeliveryStaffLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cli(){
        DefaultTableModel model = (DefaultTableModel) DeliveryUpdateFeedback.delivery.getModel();
        int selectedInfo = DeliveryUpdateFeedback.delivery.getSelectedRow();

        DeliveryUpdateFeedback.order.setText(model.getValueAt(selectedInfo, 0).toString());
        DeliveryUpdateFeedback.payment.setText(model.getValueAt(selectedInfo, 1).toString());
        DeliveryUpdateFeedback.userlabel.setText(model.getValueAt(selectedInfo, 2).toString());
        DeliveryUpdateFeedback.address.setText(model.getValueAt(selectedInfo, 3).toString());
        DeliveryUpdateFeedback.delivery2.setText(model.getValueAt(selectedInfo, 4).toString());
        DeliveryUpdateFeedback.status.setText(model.getValueAt(selectedInfo, 5).toString());
        DeliveryUpdateFeedback.feedback.setText(model.getValueAt(selectedInfo, 6).toString());
    }
    
    public void update(){
        int item = delivery.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) delivery.getModel();

        if (item >= 0) {
            model.setValueAt(DeliveryUpdateFeedback.order.getText(), item, 0);
            model.setValueAt(DeliveryUpdateFeedback.payment.getText(), item, 1);
            model.setValueAt(DeliveryUpdateFeedback.userlabel.getText(), item, 2);
            model.setValueAt(DeliveryUpdateFeedback.address.getText(), item, 3);
            model.setValueAt(DeliveryUpdateFeedback.delivery2.getText(), item, 4);
            model.setValueAt(DeliveryUpdateFeedback.status.getText(), item, 5);
            model.setValueAt(DeliveryUpdateFeedback.feedback.getText(), item, 6);

            String filePath = "deliverydetail.txt";
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount();i++){
                    colHeadings = colHeadings + model.getColumnName(i) + ":";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < DeliveryUpdateFeedback.delivery.getRowCount(); i++) {
                    for (int j = 0; j < DeliveryUpdateFeedback.delivery.getColumnCount(); j++) {
                        bw.write(DeliveryUpdateFeedback.delivery.getValueAt(i, j).toString() + ":");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(DeliveryUpdateFeedback.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "Updated SUCCESSFULLY!");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up ALL details!");
        }
    }
    
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
                    DeliveryStaffLogin.timetxt.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    DeliveryStaffLogin.datetxt.setText(df.format(date));
                }
            }
        }).start();
    }
}
