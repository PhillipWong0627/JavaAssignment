/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author user
 */
public class StaffSource {
    
    public static Integer STAFF_INCREMENT_ID = 0;

    
    public static String getStaffextId() {
        
            STAFF_INCREMENT_ID+=1;
            return "STAFF-"+STAFF_INCREMENT_ID;
		
	}
    
}
