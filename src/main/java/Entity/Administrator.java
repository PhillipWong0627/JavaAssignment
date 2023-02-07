/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Admin.AdminHomePage;
import Admin.AdminLogin;
import core.CurrentUserSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Administrator {
    private String adminName;
    private String Email;

    


    public String getAdminName() {
        return adminName;
    }

    public String getEmail() {
        return Email;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    public void login(String adminName, String password){
        
        AdminLogin adminLogin = new AdminLogin();

        
              
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
                    
                    flag = true;
                    adminLogin.dispose();
                    break;
                }else{
                    flag = false;
                    
                    
                }
            }           
            if(flag == true){
                System.out.println("==== Welcome On Board Mr/Ms " + adminName + " ====" +
                        "\nYou Have Sucessfully Login"
                        + "\nYour AdminID is "+ CurrentUserSource.currenctUserId);
                
                AdminHomePage adminHomePage = new AdminHomePage();
                
                adminHomePage.show();


   
            }else{
                System.out.println("Invalid adminname/password");
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
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
