package a2;

import java.util.List;

class PizzaFactory {
    static Pizza makePepperoniPizza(char size, int quantity){
        return new pepperoniPizza(size, quantity);
    }

    static Pizza makeMargheritaPizza(char size, int quantity){
        return new margheritaPizza(size, quantity);
    }

    static Pizza makeVegetarianPizza(char size, int quantity){
        return new vegetarianPizza(size, quantity);
    }

    static Pizza makeNeapolitanPizza(char size, int quantity){
        return new neapolitanPizza(size, quantity);
    }

    static Pizza makeCustomPizza(char size, int quantity, List<String> toppings){
        return new customPizza(size, quantity, toppings);
    }
}
