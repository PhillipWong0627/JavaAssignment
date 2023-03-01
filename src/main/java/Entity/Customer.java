/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.CustomerInterface;
import Customer.CustomerLogin;
import Customer.CustomerRegister;
import Customer.OrderPage;
import Customer.CustomerUpdateProfile;
import static Customer.CustomerUpdateProfile.profile;
import static Customer.CustomerUpdateProfile.search;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class Customer extends Payment{
    
    public boolean register() throws IOException{
        
        File customerdetail = new File("customerdetail.txt");
        FileWriter FW;
        FW = new FileWriter(customerdetail,true);
        BufferedWriter BW = new BufferedWriter(FW);
        String record = CustomerRegister.usernamere.getText()+":"+CustomerRegister.password.getText()+":"+CustomerRegister.email.getText()+":"+CustomerRegister.dateofbirth.getText()+":"+CustomerRegister.phonenumber.getText()+":"+CustomerRegister.address.getText()+"\r\n";
        BW.write(record);
        BW.close();
        FW.close();
        
        JOptionPane.showMessageDialog(null, "Successfully register, "+CustomerRegister.usernamere.getText());
        CustomerLogin cslogin = new CustomerLogin();
        cslogin.setVisible(true);
        return true;
    }
    
    
    
    public boolean login(){
        try {
            File customerinfo = new File("customerdetail.txt");
            FileReader tr = new FileReader(customerinfo);
            BufferedReader br = new BufferedReader(new FileReader(customerinfo));
            String firstLine = br.readLine().trim();
//            String[] columnName = firstLine.split(",");
            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(":");
                System.out.println(dataRow[0]);
                if(CustomerLogin.username.getText().equals(dataRow[0]) && CustomerLogin.password.getText().equals(dataRow[1])){
                    ReadUsertoPayment();
                    JOptionPane.showMessageDialog(null, "Welcome back, " + CustomerLogin.username.getText());
                    CustomerInterface csinterface = new CustomerInterface();
                    csinterface.setVisible(true);
                    return true;
                } 
            }
            } catch (IOException ex) {
            Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Wrong Username or password"); 
        return false;
    }
    
    public void CustomerUpdateProfile() {
        try {
            File customerprofile = new File("customerdetail.txt");
            FileReader tr = new FileReader(customerprofile);
            BufferedReader br = new BufferedReader(new FileReader(customerprofile));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(":");
            DefaultTableModel model = (DefaultTableModel) CustomerUpdateProfile.profile.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(":");
                model.addRow(dataRow);

            }

        } catch (IOException ex) {
            Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void search(){
        DefaultTableModel model = (DefaultTableModel) profile.getModel();
        try {
            File f = new File("customerdetail.txt");
            String SearchUsername = search.getText();
            if (SearchUsername.isEmpty()){
                return;
            }
            Scanner Sc1 = new Scanner(f);
            int Status = 0;
            while (Sc1.hasNextLine()) {
                String Line = Sc1.nextLine();
                System.out.println(Line);
                String[] myArr = Line.split(":");
                if (myArr[0].equals(SearchUsername)) {
                    Status = 1; // String found
                    CustomerUpdateProfile.username.setText(myArr[0]);
                    CustomerUpdateProfile.password.setText(myArr[1]);
                    CustomerUpdateProfile.email.setText(myArr[2]);
                    CustomerUpdateProfile.dob.setText(myArr[3]);
                    CustomerUpdateProfile.phonenumber.setText(myArr[4]);
                    CustomerUpdateProfile.address.setText(myArr[5]);
                    for(int i=0;i<model.getRowCount();i++){
                        String tempusername = (String)model.getValueAt(i,0);
                        if (tempusername.equals(myArr[0])){
                            CustomerUpdateProfile.profile.setRowSelectionInterval(i, i);
                            break;
                        }
                    }
                }
            }
            if (Status == 0) {
                 JOptionPane.showMessageDialog(null, "No such username");
            }
        } catch (IOException Ex) {
            // Handle exception
        }
    }
    
    public void update(){
        int item = profile.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) profile.getModel();

        if (item >= 0) {
            model.setValueAt(CustomerUpdateProfile.username.getText(), item, 0);
            model.setValueAt(CustomerUpdateProfile.password.getText(), item, 1);
            model.setValueAt(CustomerUpdateProfile.email.getText(), item, 2);
            model.setValueAt(CustomerUpdateProfile.dob.getText(), item, 3);
            model.setValueAt(CustomerUpdateProfile.phonenumber.getText(), item, 4);
            model.setValueAt(CustomerUpdateProfile.address.getText(), item, 5);

            String filePath = "customerdetail.txt";
            File file = new File(filePath);
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount(); i++) {
                    colHeadings = colHeadings + model.getColumnName(i) + ":";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < profile.getRowCount(); i++) {
                    for (int j = 0; j < profile.getColumnCount(); j++) {
                        bw.write(profile.getValueAt(i, j).toString() + ":");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerUpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
            } 
            JOptionPane.showMessageDialog(null, "Account Updated SUCCESSFULLY!");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up ALL details!");
        }
    }
    
    
}


