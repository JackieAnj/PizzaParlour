package a2;

import java.util.List;

public abstract class Pizza {
    String type;
    char size;
    List<String> toppings;

    public String getType(){
        return type;
    }

    public char getSize(){
        return size;
    }

    public List<String> getToppings(){
        return toppings;
    }
}

class pepperoniPizza extends Pizza {
    pepperoniPizza(char pizzaSize){
        type = "Pepperoni";
        size = pizzaSize;
        toppings.add("pepperoni");
    }
}

class margheritaPizza extends Pizza {
    margheritaPizza(char pizzaSize){
        type = "Margherita";
        size = pizzaSize;
        toppings.add("tomatoes");
        toppings.add("olives");
    }
}

class vegetarianPizza extends Pizza {
    vegetarianPizza(char pizzaSize){
        type = "Vegetarian";
        size = pizzaSize;
        toppings.add("tomatoes");
        toppings.add("olives");
        toppings.add("mushrooms");
        toppings.add("jalapenos");
    }
}

class neapolitanPizza extends Pizza {
    neapolitanPizza(char pizzaSize){
        type = "Neapolitan";
        size = pizzaSize;
        toppings.add("tomatoes");
    }
}

class customPizza extends Pizza {
    customPizza(char pizzaSize, List<String> pizzaToppings){
        type = "Custom";
        size = pizzaSize;
        toppings = pizzaToppings;
    }
}