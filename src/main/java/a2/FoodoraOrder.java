package a2;

import java.util.List;

public class FoodoraOrder extends Order {
    public FoodoraOrder(List<Pizza> pizzas, List<String> drinks) {
        super(pizzas, drinks);
    }

    public String getType() {
        return "Foodora";
    }

    public String getCsvFormat() {
        return null; // NOT IMPLEMENTED YET
    }
}
