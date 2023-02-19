/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Admin.AdminLogin;
import core.CurrentUserSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DeliveryStaff extends User {
    private String DeliveryStaffName;
    private ArrayList<Order> DeliveryOrderList;
    

    public DeliveryStaff(String DeliveryStaffName, ArrayList<Order> DeliveryOrderList, String userID, String password, String dateOfBirth, Integer phoneNumber) {
        super(userID, password, dateOfBirth, phoneNumber);
        this.DeliveryStaffName = DeliveryStaffName;
        this.DeliveryOrderList = DeliveryOrderList;
    }


    
    
    public boolean login(String staffName, String password){
      
        File adFile = new File("staffFile.txt");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(adFile));
            
            Object[] fileRow = br.lines().toArray();
//            System.out.println(br.lines());
            
            //System.out.println(fileRow);
            boolean flag = true;

            for(int i=0; i < fileRow.length;i++){
                String rows = fileRow[i].toString().trim();
                String [] dataRows = rows.split(":");
                
                //System.out.println(rows);
                //System.out.println(dataRows[1]);
                
                if(dataRows[1].equals(staffName.trim()) && dataRows[2].equals(password)){
                    
                    CurrentUserSource.currenctUserId = dataRows[0];
                    CurrentUserSource.currenctUserName = staffName;
                    CurrentUserSource.currenctUserRole = "ADMIN";
                    
                    AdminLogin adlogin = new AdminLogin();
                    adlogin.dispose();
                    
                    return true;
                }
            }           

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
}
