/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.CustomerRegister;
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
    
    public void CreateFolder(){
        if (!filename.exists()){
            filename.mkdirs();
        }
    }
    
    public void CreateFile(){
        try {
            FileReader fr = new FileReader(filename+"\\customerlogin.txt");
            System.out.println("file exists");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(filename+"\\customerlogin.txt");
                System.out.println("File created successfully");
            } catch (IOException ex1) {
                Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    public void AddData(String username, String password, String email,String dateofbirth, String phonenumber, String address, String creditcardnumber, String nameofcreditcard){
        try {
            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Username:"+username+"\r\n");
            raf.writeBytes("Password:"+password+"\r\n");
            raf.writeBytes("Email:"+email+"\r\n");
            raf.writeBytes("Date Of Birth:"+dateofbirth+"\r\n");
            raf.writeBytes("Phone Number:"+phonenumber+"\r\n");
            raf.writeBytes("Address:"+address+"\r\n");
            raf.writeBytes("Credit Card Number:"+creditcardnumber+"\r\n");
            raf.writeBytes("Name Of Credit Card:"+nameofcreditcard+"\r\n");
            JOptionPane.showMessageDialog(null, "Successfully Register, "+ username +". Proceed to login page now >.<");
            
            
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //check single set only
    public void CheckData(String username, String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
            String line = raf.readLine();
            Username = line.substring(9);
            Password = raf.readLine().substring(9);
            
            if(username.equals(Username)& password.equals(Password)){
                JOptionPane.showMessageDialog(null, "Welcome back to P&K Food Center, "+username);
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username or password");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //check multiple set
    public void logic(String username, String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
            for(int i=0; i<ln;i+=9){
                String forusername = raf.readLine().substring(9);
                String forpassword = raf.readLine().substring(9);
                System.out.println(forusername);
                if(username.equals(forusername)& password.equals(forpassword)){
                JOptionPane.showMessageDialog(null, "Welcome back to P&K Food Center, "+username);
                break;
            }else if(i==ln-8){
                JOptionPane.showMessageDialog(null, "Wrong username or password");
                break;
            }
                for(int k=1;k<=7;k++){
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void CountLines(){
        try {
            ln=1;
            RandomAccessFile raf = new RandomAccessFile(filename+"\\customerlogin.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("Number of Lines:"+ln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerLoginTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


