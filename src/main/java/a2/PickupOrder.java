package a2;

import java.util.List;

public class PickupOrder extends Order {
    public PickupOrder (List<Pizza> pizzas, List<String> drinks) {
        super(pizzas, drinks);
    }

    public String getType() {
        return "Pickup";
    }
}
