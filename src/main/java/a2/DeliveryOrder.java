package a2;

import java.util.List;

public class DeliveryOrder extends Order {
    public DeliveryOrder (List<Pizza> pizzas, List<String> drinks) {
        super(pizzas, drinks);
    }

    public String getType() {
        return "Delivery";
    }
}
