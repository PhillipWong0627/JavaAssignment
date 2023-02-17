/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author Kenny
 */
public class ShoppingCart {
    private Item[] cart;
    private double totalPrice;
    private int storedItems;
    
    public ShoppingCart(){
        cart = new Item[5];
    }
    public ShoppingCart(int cartSize){
        cart = new Item[cartSize];
    }
    
    public void addItem(Item input){
        if(storedItems<cart.length){
            cart[storedItems]=input;
            storedItems++;
        }else{
            System.out.println("Cart is full");
        }
    }
    
    public double calculateTotalPrice(){
        for(int i=0; i<cart.length;i++){
            totalPrice +=cart[i].getTotalPrice();
        }
        return totalPrice;
    }
}

