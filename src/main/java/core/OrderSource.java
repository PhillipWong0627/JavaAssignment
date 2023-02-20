/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author Kenny
 */
public class OrderSource {
    public static Integer ORDER_INCREMENT_ID = 0;

    
    public static String getOrderNextId() {
        
            ORDER_INCREMENT_ID+=1;
            return "ORDER-"+ORDER_INCREMENT_ID;
		
	}
}
