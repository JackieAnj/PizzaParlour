package a2;

import java.util.List;

class OrderFactory {
    static Order getOrder(List<Pizza> pizzas, List<Drink> drinks, String address, String type) {
        switch (type) {
            case "Pickup":
                return new PickupOrder(pizzas, drinks);
            case "Delivery":
                return new DeliveryOrder(pizzas, drinks, address);
            case "Uber":
                return new UberOrder(pizzas, drinks, address);
            case "Foodora":
                return new FoodoraOrder(pizzas, drinks, address);
            default:
                return null;
        }
    }
}
