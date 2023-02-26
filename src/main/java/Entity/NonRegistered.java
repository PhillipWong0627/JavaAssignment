/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Customer.OrderPage;
import NonRegisteredCustomer.NonROrderPage;
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
 * @author Kenny
 */
public class NonRegistered {
    public void SearchAllFood(){
        try {
            File fooddata = new File("fooddata.txt");
            FileReader tr = new FileReader(fooddata);
            BufferedReader br = new BufferedReader(new FileReader(fooddata));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel) NonROrderPage.jTable1.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(",");
                NonROrderPage.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
                NonROrderPage.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
                NonROrderPage.jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
                NonROrderPage.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
                model.addRow(dataRow);

            }

        } catch (IOException ex) {
            Logger.getLogger(NonROrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void SearchbyCategory() {
        DefaultTableModel model = (DefaultTableModel) NonROrderPage.jTable2.getModel();
        try {
            File fooddata = new File("fooddata.txt");
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
                    NonROrderPage.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
                    NonROrderPage.jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
                    NonROrderPage.jTable2.getColumnModel().getColumn(2).setPreferredWidth(50);
                    NonROrderPage.jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
                    model.addRow(dataRow);
                    NonROrderPage.searchfood.setText(OrderPage.category.getText());
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(NonROrderPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(model.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No such category, please refer back to Food List");
        }
        
    }
}
