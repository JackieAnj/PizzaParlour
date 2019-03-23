package a2;

import java.util.List;

public class DeliveryOrder extends Order {
    DeliveryOrder (List<Pizza> pizzas, List<Drink> drinks, String address) {
        super(pizzas, drinks, address);
    }

    public String getType() {
        return "Delivery";
    }
}
