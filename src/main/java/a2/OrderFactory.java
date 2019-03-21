package a2;

import java.util.List;

public class OrderFactory {
    public static Order getOrder(List<Pizza> pizzas, List<String> drinks, String type) throws Exception {
        if (type.equals("Pickup")) {
            return new PickupOrder(pizzas, drinks);
        } else if (type.equals("Delivery")) {
            return new DeliveryOrder(pizzas, drinks);
        } else if (type.equals("Uber")) {
            return new UberOrder(pizzas, drinks);
        } else if (type.equals("Foodora")) {
            return new FoodoraOrder(pizzas, drinks);
        } else {
            throw new Exception("Invalid type or order.");
        }
    }
}
