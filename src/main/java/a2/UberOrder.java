package a2;

import java.util.List;

public class UberOrder extends Order {
    public UberOrder(List<Pizza> pizzas, List<String> drinks) {
        super(pizzas, drinks);
    }

    public String getType() {
        return "Uber";
    }

    public String getJsonFormat() {
        return null; // NOT IMPLEMENTED YET
    }
}
