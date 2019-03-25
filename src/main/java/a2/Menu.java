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
    static private Map<String, Float> prices = new HashMap<>();

    static void setMenu(){
        // CREDIT https://www.journaldev.com/709/java-read-file-line-by-line
        BufferedReader reader;
        try {
            reader = new BufferedReader((new FileReader(System.getProperty("user.dir") + "/Menu.txt")));
            String item = reader.readLine().trim();
            item = reader.readLine().trim(); // Need to skip a line
            while (!item.equals("TOPPINGS")) {
                String delims = "[_]";
                String[] pizzaTokens = item.split(delims);
                pizzas.put(pizzaTokens[0], pizzaTokens[1]);
                String[] priceTokens = pizzaTokens[1].split(" ");
                int index = 0;
                float price;
                for (String s : priceTokens) {
                    index += 1;
                    if (s.equals("S:")) {
                        price = Float.parseFloat((priceTokens[index].substring(1)));
                        prices.put(pizzaTokens[0]+"_S", price);
                    } else if (s.equals("M:")) {
                        price = Float.parseFloat((priceTokens[index].substring(1)));
                        prices.put(pizzaTokens[0]+"_M", price);
                    } else if (s.equals("L:")) {
                        price = Float.parseFloat((priceTokens[index].substring(1)));
                        prices.put(pizzaTokens[0]+"_L", price);
                    }
                }
                item = reader.readLine();
            }
            item = reader.readLine();
            while (!item.equals("DRINKS")) {
                String delims = "[_]";
                String[] toppingTokens = item.split(delims);
                toppings.put(toppingTokens[0], toppingTokens[1]);
                String toppingPrice = toppingTokens[1].substring(1);
                prices.put(toppingTokens[0], Float.parseFloat(toppingPrice));
                item = reader.readLine();
            }
            item = reader.readLine();
            while (item != null) {
                String delims = "[_]";
                String[] drinkTokens = item.split(delims);
                drinks.put(drinkTokens[0], drinkTokens[1]);
                String drinkPrice = drinkTokens[1].substring(1);
                prices.put(drinkTokens[0], Float.parseFloat(drinkPrice));
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
        switch (command) {
            case "Full":
                msg = displayFullMenu();
                break;
            case "Pizzas":
                msg = displayPizzaMenu();
                break;
            case "Toppings":
                msg = displayToppingsMenu();
                break;
            case "Drinks":
                msg = displayDrinksMenu();
                break;
            default:
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
                break;
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
            result = String.format("%s%s\n", result, key + " ==> " + pizzas.get(key));
        }
        return result;
    }

    private static String displayToppingsMenu() {
        String result = " == TOPPINGS ==============================\n";
        //System.out.println(" == TOPPINGS ==============================");
        for (String key : toppings.keySet()) {
            result = String.format("%s%s ==> %s\n", result, key, toppings.get(key));
        }
        return result;
    }

    private static String displayDrinksMenu() {
        StringBuilder result = new StringBuilder("== DRINKS ==============================\n");
        //System.out.println("== DRINKS ==============================");
        for (String key : drinks.keySet()){
            result.append(key).append(" ==> ").append(drinks.get(key)).append("\n");
        }
        return result.toString();
    }

    static String getTotal(Order order){
        double total = 0.0;
        for (Pizza p: order.getPizzas()){
            String item = p.getType() + " Pizza_" + p.getSize();
            double price = prices.get(item);
            if (p.getType().equals("Custom")){
                for (String t: p.getToppings()){
                    price += prices.get(t);
                }
            }
            total += price * p.getQuantity();
        }
        for (Drink d: order.getDrinks()){
            total += prices.get(d.getName()) * d.getQuantity();
        }
        return "Total: $" + Double.toString(total);
    }
}
