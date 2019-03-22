package a2;

import java.util.List;

public class FoodoraOrder extends Order {
    public FoodoraOrder(List<Pizza> pizzas, List<Drink> drinks, String address) {
        super(pizzas, drinks, address);
    }

    public String getType() {
        return "Foodora";
    }

    public String getCsvFormat() {
        return null; // NOT IMPLEMENTED YET
    }
}
