/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author user
 */
class Category {
    
    private String CategoryType;

    public Category(String CategoryType) {
        this.CategoryType = CategoryType;
    }
    
    
    
    
    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String CategoryType) {
        this.CategoryType = CategoryType;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryType=" + CategoryType + '}';
    }
    
    

    
 
    
}
