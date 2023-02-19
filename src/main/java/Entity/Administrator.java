/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Admin.AdminLogin;
import core.AdminSource;
import core.CurrentUserSource;
import core.StaffSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Administrator {
    private String adminId;
    private String adminName;
    private String Email;

    public String getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getEmail() {
        return Email;
    }
    
    

   
    public boolean login(String adminName, String password){
      
        File adFile = new File("adminFile.txt");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(adFile));
            
            Object[] fileRow = br.lines().toArray();
            //System.out.println(fileRow);
            boolean flag = true;

            for(int i=0; i < fileRow.length;i++){
                String rows = fileRow[i].toString().trim();
                String [] dataRows = rows.split(":");
                
                //System.out.println(rows);
                //System.out.println(dataRows[1]);
                
                if(dataRows[1].equals(adminName.trim()) && dataRows[2].equals(password)){
                    
                    CurrentUserSource.currenctUserId = dataRows[0];
                    CurrentUserSource.currenctUserName = adminName;
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
    
    public void addAdmin(String adminName, String password, String email, String phNo) throws IOException{
        //Take name, password, email, phone
        
        String adId = AdminSource.getAdminNextId();
        
        File file = new File("adminFile.txt");
        FileWriter FW;
       
        FW = new FileWriter(file,true);
        BufferedWriter BW = new BufferedWriter(FW);

        String record = adId + ":"+ adminName+":"+ password+ ":" + email + ":"+ phNo+ "\n";

        BW.write(record);
        BW.close();
        FW.close();
        
        System.out.println("Admin Have Been Successfully Added");
        

        
    }
    
    public void addStaff(String staffName, String password, String phNo) throws IOException{
        
        String staffId = StaffSource.getStaffextId();
        
        File file = new File("staffFile.txt");
        FileWriter FW;
       
        FW = new FileWriter(file,true);
        BufferedWriter BW = new BufferedWriter(FW);

        String record = staffId + ":"+ staffName+":"+ password + ":"+ phNo+ "\n";

        BW.write(record);
        BW.close();
        FW.close();
        
        System.out.println("Staff Have Been Successfully Added");


        
    }
    
    public void ModifyAdmin() throws FileNotFoundException{    
        
        Scanner sc = new Scanner(System.in);
        File adminFile = new File("adminFile.txt");
                
            BufferedReader br = new BufferedReader(new FileReader(adminFile));

            
            Object[] fileRow = br.lines().toArray();
//            System.out.println(fileRow);
            String checkName = sc.nextLine();


            for(int i=0; i < fileRow.length;i++){
                String rows = fileRow[i].toString().trim();
                String [] dataRows = rows.split(":");
                
                
                //System.out.println(rows);
                System.out.println(dataRows[0]);
                
                if(dataRows[0].equals(checkName)){
                    System.out.println("SMTG");
                }else{
                    System.out.println("Failed");
                }
              
            } 
        
        
    }
    

    
    public void updateUser(){
        
        
    }
    
    public void updateCategory(){
        
        
    }
    
    public void searchPayment(){
        
    }
    
    public void searchOrder(){
        
    }
    
    public void assignOrder(){
        
    }
    
    public void updateCategoryWise(){
        
        
    }


    
    
    
}
