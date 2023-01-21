/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author user
 */
class Food {
    
    private String FoodID;
    private String Name;
    private Float FoodPrice;
    private Category Category;
    
    public void Food(String foodId, String name, Float foodPrice, Category category){
        this.FoodID = foodId;
        this.Name = name;
        this.FoodPrice = foodPrice;
        this.Category = category;
    }
    
}
