package a2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    static Map<String, String> pizzas = new HashMap<>();
    static Map<String, String> toppings = new HashMap<>();
    static Map<String, String> drinks = new HashMap<>();

    public static void getMenu(){
        // CREDIT https://www.journaldev.com/709/java-read-file-line-by-line
        BufferedReader reader;
        try {
            reader = new BufferedReader((new FileReader(System.getProperty("user.dir") + "/Menu.txt")));
            String item = reader.readLine().trim();
            item = reader.readLine().trim();
            while (!item.equals("TOPPINGS")) {
                String delims = "[_]";
                String[] pizzaTokens = item.split(delims);
                pizzas.put(pizzaTokens[0], pizzaTokens[1]);
                item = reader.readLine();
            }
            item = reader.readLine();
            while (!item.equals("DRINKS")) {
                String delims = "[_]";
                String[] toppingTokens = item.split(delims);
                toppings.put(toppingTokens[0], toppingTokens[1]);
                item = reader.readLine();
            }
            item = reader.readLine();
            while (item != null) {
                String delims = "[_]";
                String[] drinkTokens = item.split(delims);
                drinks.put(drinkTokens[0], drinkTokens[1]);
                item = reader.readLine();
            }
            reader.close();
            System.out.println(pizzas);
            System.out.println(toppings);
            System.out.println(drinks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void displayFullMenu(){

    }

    public void displayMenuItem(String item){

    }
}
