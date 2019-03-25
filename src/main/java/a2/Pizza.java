package a2;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String type;
    private char size;
    List<String> toppings = new ArrayList<>();
    private int quantity;
    private int pizzaId;
    private static int currentId = 1;

    String getType(){
        return type;
    }

    char getSize(){
        return size;
    }

    List<String> getToppings(){
        return toppings;
    }

    int getQuantity() {return quantity; }

    int getPizzaId() {
        return pizzaId;
    }

    public Pizza(char size, int quantity) {
        this.size = size;
        this.quantity = quantity;
        this.pizzaId = currentId;
        currentId += 1;
        if (currentId > 1000) {
            currentId = 1;
        }
    }

    @Override
    public String toString() {
        return "Pizza #" + pizzaId + " ---> " +
                "type=" + type + " && " +
                "size=" + size + " && " +
                "toppings=" + toppings + " && " +
                "quantity=" + quantity;
    }
}

class pepperoniPizza extends Pizza {
    pepperoniPizza(char size, int quantity){
        super(size, quantity);
        type = "Pepperoni";
        toppings.add("Pepperoni");
    }
}

class margheritaPizza extends Pizza {
    margheritaPizza(char size, int quantity){
        super(size, quantity);
        type = "Margherita";
        toppings.add("Tomatoes");
        toppings.add("Olives");
    }
}

class vegetarianPizza extends Pizza {
    vegetarianPizza(char size, int quantity){
        super(size, quantity);
        type = "Vegetarian";
        toppings.add("Tomatoes");
        toppings.add("Olives");
        toppings.add("Mushrooms");
        toppings.add("Jalapenos");
    }
}

class neapolitanPizza extends Pizza {
    neapolitanPizza(char size, int quantity){
        super(size, quantity);
        type = "Neapolitan";
        toppings.add("Tomatoes");
    }
}

class customPizza extends Pizza {
    customPizza(char size, int quantity, List<String> pizzaToppings){
        super(size, quantity);
        type = "Custom";
        toppings = pizzaToppings;
    }
}