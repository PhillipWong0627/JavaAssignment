/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author Kenny
 */
public class TestCart {
    public static void main(String[] args) {
        Item pen = new Item("ball pen",3,15);
        Item laptop = new Item("HP",1,15000);
        Item mobile = new Item("Samsung",1,20000);
        Item wire = new Item("cat 6",1,100);
        Item book = new Item("oop",1,200);
        
        ShoppingCart qasim = new ShoppingCart();
        qasim.addItem(pen);
        qasim.addItem(laptop);
        qasim.addItem(mobile);
        
        System.out.println(qasim.calculateTotalPrice());
    }
}
