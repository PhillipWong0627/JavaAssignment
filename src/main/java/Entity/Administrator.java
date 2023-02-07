/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Admin.AdminLogin;
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
    
    public void Adminstrator(String adName, String email){
        this.adminName = adName;
        this.Email = email;
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
    
    public void login(String adminName, String password){
              
        File adFile = new File("C:\\Users\\user\\Desktop\\Java\\FoodJavaAssignment\\JavaAssignment\\src\\main\\java\\Admin\\adminFile.txt");
        
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
                    flag = true;
                    break;
                }else{
                    flag = false;
                    
                }
            }           
            if(flag == true){
                System.out.println("Sucessfully Login");
                
//                Admin_Page aPage = new Admin_Page();   
//                aPage.show();
//                dispose();   
            }else{
                System.out.println("Invalid username/password");
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    
    
}
