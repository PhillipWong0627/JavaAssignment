/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.IOException;

/**
 *
 * @author user
 */
public class Cart {
    private Integer cartID;
    private Food food;
    private Integer quantity;
    
    public void Cart(Integer cartId, Food food, Integer qty){
        this.cartID = cartId;
        this.food = food;
        this.quantity = qty;
    }
    
    public void PKFC() throws IOException{
        receipt.setText("**********************Philip & Kenny Food Centre**********************\n"
        +"              Time: "+timetxt.getText()+"          Date: "+datetxt.getText()+"\n"
        +"**************************************************************************"+"\n"
        +"FoodID:\t"+"Item Name:\t\t"+"Price($)\n"
        );
        

    }
}
