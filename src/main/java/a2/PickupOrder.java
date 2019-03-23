package a2;

import java.util.List;

public class PickupOrder extends Order {
    PickupOrder (List<Pizza> pizzas, List<Drink> drinks) {
        super(pizzas, drinks, "309 Pizza Parlour");
    }

    public String getType() {
        return "Pickup";
    }
}
