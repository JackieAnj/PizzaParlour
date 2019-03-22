package a2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

class Menu {

    static private Map<String, String> pizzas = new HashMap<>();
    static private Map<String, String> toppings = new HashMap<>();
    static private Map<String, String> drinks = new HashMap<>();

    static void setMenu(){
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String displayMenu(String userCommand) {
        String delims = "[-]";
        String[] commandTokens = userCommand.split(delims);
        String command = commandTokens[1];
        String msg = command + " is not a valid menu item";
        if (command.equals("Full")){
            msg = displayFullMenu();
        } else if (command.equals("Pizzas")) {
            msg = displayPizzaMenu();
        } else if (command.equals("Toppings")) {
            msg = displayToppingsMenu();
        } else if (command.equals("Drinks")) {
            msg = displayDrinksMenu();
        } else {
            String value = pizzas.get(command);
            if (value != null) {
                msg = command + " ==> " + value;
            }
            value = toppings.get(command);
            if (value != null) {
                msg = command + " ==> " + value;
            }
            value = drinks.get(command);
            if (value != null) {
                msg = command + " ==> " + value;
            }
            //System.out.println(msg);
        }
        return msg;
    }
    private static String displayFullMenu(){
        return displayPizzaMenu() + displayToppingsMenu() + displayDrinksMenu();
    }

    private static String displayPizzaMenu() {
        String result = "== PIZZAS ==============================\n";
        //System.out.println("== PIZZAS ==============================");
        for (String key : pizzas.keySet()){
            result = result + (key + " ==> " + pizzas.get(key)) + "\n";
        }
        return result;
    }

    private static String displayToppingsMenu() {
        String result = " == TOPPINGS ==============================\n";
        //System.out.println(" == TOPPINGS ==============================");
        for (String key : toppings.keySet()){
            result = result + (key + " ==> " + toppings.get(key)) + "\n";
        }
        return result;
    }

    private static String displayDrinksMenu() {
        String result = "== DRINKS ==============================\n";
        //System.out.println("== DRINKS ==============================");
        for (String key : drinks.keySet()){
            result = result + (key + " ==> " + drinks.get(key)) + "\n";
        }
        return result;
    }
}
