/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeTesterr;

import Entity.Administrator;
import java.io.IOException;

/**
 *
 * @author user
 */
public class Testing {
    
    public static void main(String [] args) throws IOException{
  
        Administrator a = new Administrator();
//        a.displayItem1();

        String id = "AA";
        a.addCategory(id, "HaloBinJeK");
        a.toString();

    }
    
}
