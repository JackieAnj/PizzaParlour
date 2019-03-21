package a2;

import java.util.List;

public class PizzaFactory {
    public static Pizza makePepperoniPizza(char size, int quantity){
        return new pepperoniPizza(size, quantity);
    }

    public static Pizza makeMargheritaPizza(char size, int quantity){
        return new margheritaPizza(size, quantity);
    }

    public static Pizza makeVegetarianPizza(char size, int quantity){
        return new vegetarianPizza(size, quantity);
    }

    public static Pizza makeNeapolitanPizza(char size, int quantity){
        return new neapolitanPizza(size, quantity);
    }

    public static Pizza makeCustomPizza(char size, int quantity, List<String> toppings){
        return new customPizza(size, quantity, toppings);
    }
}
