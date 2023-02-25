/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.OrderPage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Food{
    
    private String FoodID;
    private String Name;
    private Float FoodPrice;
    private Category Category;

    Food(String foodID, String Name, Float foodPrice, String CatType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
//    public void Food(String foodId, String name, Float foodPrice, Category category){
//        this.FoodID = foodId;
//        this.Name = name;
//        this.FoodPrice = foodPrice;
//        this.Category = category;
//    }

    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Float getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(Float FoodPrice) {
        this.FoodPrice = FoodPrice;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category Category) {
        this.Category = Category;
    }
    
    
    public Food(){
        
    }

    public Food(String FoodID, String Name, Float FoodPrice, Category Category) {
        this.FoodID = FoodID;
        this.Name = Name;
        this.FoodPrice = FoodPrice;
        this.Category = Category;
    }
    
    public void setFood(){
        
        
    }
    
    
    

    @Override
    public String toString() {
        return "Food{" + "FoodID=" + FoodID + ", Name=" + Name + ", FoodPrice=" + FoodPrice + ", Category=" + Category + '}';
    }
    
    
    public void SearchAllFood(){
        try {
            File fooddata = new File("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\fooddata\\fooddata.txt");
            FileReader tr = new FileReader(fooddata);
            BufferedReader br = new BufferedReader(new FileReader(fooddata));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel) OrderPage.jTable1.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(",");
                OrderPage.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
                OrderPage.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
                OrderPage.jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
                OrderPage.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
                model.addRow(dataRow);

            }

        } catch (IOException ex) {
            Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void SearchbyCategory() {
        DefaultTableModel model = (DefaultTableModel) OrderPage.jTable2.getModel();
        try {
            File fooddata = new File("C:\\Users\\Kenny\\OneDrive\\Documents\\NetBeansProjects\\Online Order and Delivery System\\txtfile\\fooddata\\fooddata.txt");
            FileReader tr = new FileReader(fooddata);
            BufferedReader br = new BufferedReader(new FileReader(fooddata));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(",");
            model.setRowCount(0);
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(",");
                if (dataRow[3].equals(OrderPage.category.getText())) {
                    OrderPage.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
                    OrderPage.jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
                    OrderPage.jTable2.getColumnModel().getColumn(2).setPreferredWidth(50);
                    OrderPage.jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
                    model.addRow(dataRow);
                    OrderPage.searchfood.setText(OrderPage.category.getText());
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(model.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No such category, please refer back to Food List");
        }
        
    }
    
    
}
