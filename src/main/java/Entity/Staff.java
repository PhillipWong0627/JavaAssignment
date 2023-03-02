/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Delivery.DeliveryInterface;
import static Delivery.DeliveryInterface.delivery;
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
            DefaultTableModel model = (DefaultTableModel) DeliveryInterface.delivery.getModel();
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
        DefaultTableModel model = (DefaultTableModel) DeliveryInterface.delivery.getModel();
        int selectedInfo = DeliveryInterface.delivery.getSelectedRow();

        DeliveryInterface.order.setText(model.getValueAt(selectedInfo, 0).toString());
        DeliveryInterface.payment.setText(model.getValueAt(selectedInfo, 1).toString());
        DeliveryInterface.userlabel.setText(model.getValueAt(selectedInfo, 2).toString());
        DeliveryInterface.address.setText(model.getValueAt(selectedInfo, 3).toString());
        DeliveryInterface.delivery2.setText(model.getValueAt(selectedInfo, 4).toString());
        DeliveryInterface.status.setText(model.getValueAt(selectedInfo, 5).toString());
        DeliveryInterface.feedback.setText(model.getValueAt(selectedInfo, 6).toString());
    }
    
    public void update(){
        int item = delivery.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) delivery.getModel();

        if (item >= 0) {
            model.setValueAt(DeliveryInterface.order.getText(), item, 0);
            model.setValueAt(DeliveryInterface.payment.getText(), item, 1);
            model.setValueAt(DeliveryInterface.userlabel.getText(), item, 2);
            model.setValueAt(DeliveryInterface.address.getText(), item, 3);
            model.setValueAt(DeliveryInterface.delivery2.getText(), item, 4);
            model.setValueAt(DeliveryInterface.status.getText(), item, 5);
            model.setValueAt(DeliveryInterface.feedback.getText(), item, 6);

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

                for (int i = 0; i < DeliveryInterface.delivery.getRowCount(); i++) {
                    for (int j = 0; j < DeliveryInterface.delivery.getColumnCount(); j++) {
                        bw.write(DeliveryInterface.delivery.getValueAt(i, j).toString() + ":");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(DeliveryInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "Updated SUCCESSFULLY!");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up ALL details!");
        }
    }
}
