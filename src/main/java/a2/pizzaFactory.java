package a2;

import java.util.List;

public class pizzaFactory {
    public Pizza makePepperoniPizza(char size){
        return new pepperoniPizza(size);
    }

    public Pizza makeMargheritaPizza(char size){
        return new margheritaPizza(size);
    }

    public Pizza makeVegetarianPizza(char size){
        return new vegetarianPizza(size);
    }

    public Pizza makeNeapolitanPizza(char size){
        return new neapolitanPizza(size);
    }

    public Pizza makeCustomPizza(char size, List<String> toppings){
        return new customPizza(size, toppings);
    }
}
