package a2;

import java.util.List;

public class UberOrder extends Order {
    public UberOrder(List<Pizza> pizzas, List<Drink> drinks, String address) {
        super(pizzas, drinks, address);
    }

    public String getType() {
        return "Uber";
    }

    public String getJsonFormat() {
        return null; // NOT IMPLEMENTED YET
    }
}
