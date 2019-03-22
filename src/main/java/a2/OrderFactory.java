package a2;

import java.util.List;

public class OrderFactory {
    public static Order getOrder(List<Pizza> pizzas, List<Drink> drinks, String address, String type) {
        if (type.equals("Pickup")) {
            return new PickupOrder(pizzas, drinks);
        } else if (type.equals("Delivery")) {
            return new DeliveryOrder(pizzas, drinks, address);
        } else if (type.equals("Uber")) {
            return new UberOrder(pizzas, drinks, address);
        } else if (type.equals("Foodora")) {
            return new FoodoraOrder(pizzas, drinks, address);
        } else {
            return null;
        }
    }
}
