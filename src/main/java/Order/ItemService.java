/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Order.Item;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sourcecodester
 */
public class ItemService {

    public ItemService() {
    }

    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("food.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(";");
                
                

                Item item = new Item(itemInfo[0], (itemInfo[1]),
                        Double.parseDouble(itemInfo[2]), (itemInfo[3]));

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    public Item getItemByIndex(int index) {
        List<Item> listOfItem = getAll();

        if (listOfItem.size() >= index) {
            return listOfItem.get(index - 1);
        }

        return null;
    }

 
}
