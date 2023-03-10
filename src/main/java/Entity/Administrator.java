/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Admin.AdminAssign;
import Admin.AdminLogin;
import Customer.CustomerLogin;
import Customer.OrderPage;
import static Delivery.DeliveryUpdateFeedback.delivery;
import DisplayData.DisplayItemWise;
import core.AdminSource;
import core.CurrentUserSource;
import core.StaffSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class Administrator  {
    private String adminId;
    private String adminName;
    private String Email;
    private final ArrayList<String> myItemList = new ArrayList<>();


    public String getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getEmail() {
        return Email;
    }
    
    public Administrator(){}
    
    public boolean login(String adminName, String password){
        File adFile = new File("adminFile.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(adFile));
            Object[] fileRow = br.lines().toArray();

            for(int i=0; i < fileRow.length;i++){
                String rows = fileRow[i].toString().trim();
                String [] dataRows = rows.split(":");
                
                if(dataRows[1].equals(adminName.trim()) && dataRows[2].equals(password)){
                    CurrentUserSource.currenctUserId = dataRows[0];
                    CurrentUserSource.currenctUserName = adminName;
                    CurrentUserSource.currenctUserRole = "ADMIN";
                    
                    AdminLogin adlogin = new AdminLogin();
                    adlogin.dispose();
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Maybe need to enhace Xia NOT NECESSARY
    public ArrayList<String> displayItem1(){
        File adfile = new File("fooddata.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(adfile));
            
            String strHeader = br.readLine().trim();
//            System.out.println(colHeader);

            String[] columnHeader = strHeader.split(":");
//            DefaultTableModel tModel = (DefaultTableModel) adminTable.getModel(); 
            // set the column header
//            tModel.setColumnIdentifiers(columnHeader);

//            System.out.println(Arrays.toString(columnHeader));
            
            Object[] tableRow = br.lines().toArray();
            ArrayList<String> ListItem = new ArrayList <>();

            
            for(int i = 0; i<tableRow.length;i++){
//                System.out.println(tableRow[i]);
                String lines = tableRow[i].toString().trim();
//                System.out.println(lines);
                String [] dataRows = lines.split(":");
                
                myItemList.add(lines);
                
                ListItem = myItemList;
                
                

            }
            
//            System.out.println(ListItem.size());
            return ListItem;

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisplayItemWise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisplayItemWise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myItemList;
        
    }
    
    
    
    
    
    public void addAdmin(String adminName, String password, String email, String phNo) throws IOException{
        //Take name, password, email, phone
        
        String adId = AdminSource.getAdminNextId();
        
        File file = new File("adminFile.txt");
        FileWriter FW;
       
        FW = new FileWriter(file,true);
        BufferedWriter BW = new BufferedWriter(FW);

        String record = adId + ":"+ adminName+":"+ password+ ":" + email + ":"+ phNo+ "\n";

        BW.write(record);
        BW.close();
        FW.close();
        
        System.out.println("Admin Have Been Successfully Added");
        

        
    }
    
    public void addStaff(String staffName, String password, String phNo) throws IOException{
        
        String staffId = StaffSource.getStaffextId();
        
        File file = new File("staffFile.txt");
        FileWriter FW;
       
        FW = new FileWriter(file,true);
        BufferedWriter BW = new BufferedWriter(FW);

        String record = staffId + ":"+ staffName+":"+ password + ":"+ phNo+ "\n";

        BW.write(record);
        BW.close();
        FW.close();
        
        System.out.println("Staff Have Been Successfully Added");

    }
    
    public void addItem(String foodID, String Name, Float foodPrice, String CatType) throws IOException{
        
        int foodId = 1;
        
        File Cat = new File("fooddata.txt");
        FileReader fr = new FileReader(Cat);
        FileWriter FW;

        
        BufferedReader brr = new BufferedReader(new FileReader(Cat));
        String firstLine = brr.readLine().trim();
        Object[] tableLines = brr.lines().toArray();

//        System.out.println(tableLines.length);
        for (int i = 0; i < tableLines.length ; i++) {
            String line1 = tableLines[i].toString().trim();
            System.out.println(line1);
            
            
            foodId++;

        }
        
        Category c = new Category(CatType);
        Food f = new Food(foodID,Name,foodPrice,c);
        
        System.out.println(f.toString());
        
//        System.out.println(f.getFoodID());
        
        File file = new File("fooddata.txt");
       
        FW = new FileWriter(file,true);
        try (BufferedWriter BW = new BufferedWriter(FW)) {
            String record = foodId + ","+ f.getName()+","+ f.getFoodPrice() + ","+ f.getCategory().getCategoryType()+ "\n";
            
            BW.write(record);
            System.out.println("Food Item Have Been Successfully Added");

            
        }
        FW.close();
        
    
    }
    
    public void addCategory(String CategoryID, String CategoryType ) throws IOException{
        int CatId = 1;
        
        Category c = new Category(CategoryType);
        
//        System.out.println(c.toString());

        File Cat = new File("Category.txt");
        FileReader fr = new FileReader(Cat);
        FileWriter FW;

        
        BufferedReader brr = new BufferedReader(new FileReader(Cat));
        String firstLine = brr.readLine().trim();
        Object[] tableLines = brr.lines().toArray();

//        System.out.println(tableLines.length);
        for (int i = 0; i < tableLines.length ; i++) {
            String line1 = tableLines[i].toString().trim();
            System.out.println(line1);
            
            
            
            CatId++;

        }
        
         
        File file = new File("Category.txt");
       
        FW = new FileWriter(file,true);
        try (BufferedWriter BW = new BufferedWriter(FW)) {
            String record = CatId + ":"+ c.getCategoryType()+ "\n";

            BW.write(record);
            System.out.println("Category Have Been Successfully Added");

            
        }
        FW.close();
        
    
    }
    public boolean checkUserRole(String UserName) throws FileNotFoundException{
        File AuditLogFile = new File("loginactivity.txt");
        
        
        String admintoFind = UserName;
        Scanner scanner = new Scanner(AuditLogFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(admintoFind)){
//                Status = 1;
//                String[] myArr = Line.split(":");
                
                JOptionPane.showMessageDialog(null, "Success Search");
                System.out.println("Success Search");
                return true;
                
            }
            
            
        }
        if(Status ==0){
            JOptionPane.showMessageDialog(null, "UserRole Not found");

            System.out.println("Admin Not found");
        }
        return false;
        
        
    }
   
    
    public boolean searchAdmin(String adminID) throws FileNotFoundException{
        File adminFile = new File("adminFile.txt");
        
        
        String admintoFind = adminID;
        Scanner scanner = new Scanner(adminFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(admintoFind)){
//                Status = 1;
//                String[] myArr = Line.split(":");
                
                System.out.println("Success Search");
                return true;
                
            }
            
            
        }
        if(Status ==0){
            System.out.println("Admin Not found");
        }
        return false;
        
        
    }
    
    public boolean searchStaff(String staffID) throws FileNotFoundException{
        File staffFile = new File("staffFile.txt");
        
        
        String stafftoFind = staffID;
        Scanner scanner = new Scanner(staffFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(stafftoFind)){
//                Status = 1;
//                String[] myArr = Line.split(":");
                
                System.out.println("Success Search");
                return true;
                
            }
            
            
        }
        if(Status ==0){
            System.out.println("Admin Not found");
        }
        return false;
        
        
    }
    
    public boolean searchCategory(String catID) throws FileNotFoundException{
        File CatFile = new File("Category.txt");
        
        
        String CatToFind = catID;
        Scanner scanner = new Scanner(CatFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(CatToFind)){

                System.out.println("Success Search");
                return true;
                
            }
            
        }
        if(Status ==0){
            System.out.println("Category Not found");
        }
        return false;
        
        
    }
    
    public boolean searchItem(String foodID) throws FileNotFoundException{
        File FoodFile = new File("fooddata.txt");
        
        
        String ItemToFind = foodID;
        Scanner scanner = new Scanner(FoodFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(ItemToFind)){

                System.out.println("Success Search");
                return true;
                
            }
            
        }
        if(Status ==0){
            System.out.println("Item Not found");
        }
        return false;
        
        
    }
    
    
    public boolean searchCustPayment(String OrderID) throws FileNotFoundException{
        File FoodFile = new File("creditcarddetail.txt");
        
        
        String CustPayToFind = OrderID;
        Scanner scanner = new Scanner(FoodFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(CustPayToFind)){

                System.out.println("Success Search");
                return true;
                
            }
            
        }
        if(Status ==0){
            System.out.println("Item Not found");
        }
        return false;
        
        
    }
    
    
    public boolean searchOrder(String OrderID) throws FileNotFoundException{
        File OrderFile = new File("orderdetail.txt");
        
        String OrderToFind = OrderID;
        Scanner scanner = new Scanner(OrderFile);
        
        int Status = 0;
        while(scanner.hasNextLine()){
            String Line = scanner.nextLine();
            if(Line.contains(OrderToFind)){

                System.out.println("Success Search");
                return true;
            }
            
        }
        if(Status ==0){
            System.out.println("Item Not found");
        }
        return false;
        
        
    }
    
    

        public void am(){
            DefaultTableModel model = (DefaultTableModel) AdminAssign.delivery.getModel();
        int selectedInfo = AdminAssign.delivery.getSelectedRow();

        AdminAssign.order.setText(model.getValueAt(selectedInfo, 0).toString());
        AdminAssign.payment.setText(model.getValueAt(selectedInfo, 1).toString());
        AdminAssign.userlabel.setText(model.getValueAt(selectedInfo, 2).toString());
        AdminAssign.address.setText(model.getValueAt(selectedInfo, 3).toString());
        AdminAssign.delivery2.setText(model.getValueAt(selectedInfo, 4).toString());
        AdminAssign.status1.setText(model.getValueAt(selectedInfo, 5).toString());
        AdminAssign.feedback.setText(model.getValueAt(selectedInfo, 6).toString());
        }
        
        public void adminupdate(){
            int item = AdminAssign.delivery.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) AdminAssign.delivery.getModel();

        if (item >= 0) {
            model.setValueAt(AdminAssign.order.getText(), item, 0);
            model.setValueAt(AdminAssign.payment.getText(), item, 1);
            model.setValueAt(AdminAssign.userlabel.getText(), item, 2);
            model.setValueAt(AdminAssign.address.getText(), item, 3);
            model.setValueAt(AdminAssign.delivery2.getText(), item, 4);
            model.setValueAt(AdminAssign.status1.getText(), item, 5);
            model.setValueAt(AdminAssign.feedback.getText(), item, 6);

            String filePath = "deliverydetail.txt";
            File file = new File(filePath);
            try {

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String colHeadings = "";
                for (int i = 0; i < model.getColumnCount();i++){
                    colHeadings = colHeadings + model.getColumnName(i) + ":";
                }
                bw.write(colHeadings + "\n");

                for (int i = 0; i < AdminAssign.delivery.getRowCount(); i++) {
                    for (int j = 0; j < AdminAssign.delivery.getColumnCount(); j++) {
                        bw.write(AdminAssign.delivery.getValueAt(i, j).toString() + ":");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AdminAssign.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "Updated SUCCESSFULLY!");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up ALL details!");
        }
    
    }
        public void DeliveryDetailsTable() {
        try {
            File deliverydetail = new File("deliverydetail.txt");
            FileReader tr = new FileReader(deliverydetail);
            BufferedReader br = new BufferedReader(new FileReader(deliverydetail));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(":");
            DefaultTableModel model = (DefaultTableModel) AdminAssign.delivery.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            for (int z = 0; z < tableLines.length; z++) {
                String line = tableLines[z].toString().trim();
                String[] dataRow = line.split(":");
                model.addRow(dataRow);

            }

        } catch (IOException ex) {
            Logger.getLogger(AdminAssign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(OrderPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    AdminLogin.timetxt.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    AdminLogin.datetxt.setText(df.format(date));
                }
            }
        }).start();
    }
}
