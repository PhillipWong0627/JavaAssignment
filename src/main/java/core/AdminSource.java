/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author user
 */
public class AdminSource {
    
    public static Integer ADMIN_INCREMENT_ID = 0;

    
    public static String getAdminNextId() {
        
            ADMIN_INCREMENT_ID+=1;
            return "ADMIN-"+ADMIN_INCREMENT_ID;
		
	}
    
}
