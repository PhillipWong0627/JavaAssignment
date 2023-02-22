/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.CustomerLogin;
import Customer.CustomerRegister;
import Customer.OrderPage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Customer{
    private String customerName;
    private String customerAddress;
    private String Email;
    private Integer creditCardNo;
    private ArrayList<Cart> carList;
    
    File filename = new File ("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\customerinfo");
    int ln;
    String Username,Password;
    
    public void Customer (String custName, String custAddress, String email,Integer creditCardNo, ArrayList<Cart> cartList){
        this.customerName = custName;
        this.customerAddress = custAddress;
        this.Email = email;
        this.creditCardNo = creditCardNo;
        this.carList = cartList;
    }
    
//    public void CreateFolder(){
//        if (!filename.exists()){
//            filename.mkdirs();
//        }
//    }
//    
//    public void CreateFile(){
//        try {
//            FileReader fr = new FileReader(filename+"\\customerlogin.txt");
//            System.out.println("file exists");
//        } catch (FileNotFoundException ex) {
//            try {
//                FileWriter fw = new FileWriter(filename+"\\customerlogin.txt");
//                System.out.println("File created successfully");
//            } catch (IOException ex1) {
//                Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//        }
//    }
    public void AddData(String username, String password, String email,String dateofbirth, String phonenumber, String address){
        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\customerdetail\\customerdetail.txt", "rw");
            
            for(int i=0;i<ln;i++){
                raf.readLine(); 
            }
                
                raf.writeBytes(username+":"+password+":"+email+":"+dateofbirth+":"+phonenumber+":"+address+"\r\n");
                JOptionPane.showMessageDialog(null, "Successfully Register, "+ username +". Proceed to login page now >.<");  
                
                
            
            
            
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //check single set only
//    public void CheckData(String username, String password){
//        try {
//            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
//            String line = raf.readLine();
//            Username = line.substring(9);
//            Password = raf.readLine().substring(9);
//            
//            if(username.equals(Username)& password.equals(Password)){
//                JOptionPane.showMessageDialog(null, "Welcome back to P&K Food Center, "+username);
//            }else{
//                JOptionPane.showMessageDialog(null, "Wrong username or password");
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    //check multiple set
//    public void logic(String username, String password){
//        try {
//            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
//            for(int i=0; i<ln;i+=9){
//                System.out.println("count "+i);
//                String forusername = raf.readLine().substring(9);
//                String forpassword = raf.readLine().substring(9);
//                System.out.println(forusername);
//                if(username.equals(forusername)& password.equals(forpassword)){
//                JOptionPane.showMessageDialog(null, "Welcome back to P&K Food Center, "+username);
//                break;
//                    }else if(i==(ln-8)){
//                    JOptionPane.showMessageDialog(null, "Wrong username or password");
//                    break;  
//            }
//                for(int k=1;k<=7;k++){
//                    raf.readLine();
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(CustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void CountLines(){
//        try {
//            ln=1;
//            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
//            for(int i=0;raf.readLine()!=null;i++){
//                ln++;
//            }
//            System.out.println("Number of Lines:"+ln);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public void checkduplicate(String username){
//        ln=1;
//        try {
//            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
//            for(int i=0; i<ln;i+=9){
//                System.out.println("count "+i);
//                String forusername = raf.readLine().substring(9);
//                if(username.equals(forusername)){
//                    System.out.println("Username exist");
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }   
    public void login(){
        try {
            File customerinfo = new File("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\customerdetail\\customerdetail.txt");
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
                    JOptionPane.showMessageDialog(null, "Welcome back, " + CustomerLogin.username.getText());
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username or password");
                }   
            }
            } catch (IOException ex) {
            Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void register(){
        
    }
}


