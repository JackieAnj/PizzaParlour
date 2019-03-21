package a2;

import java.util.List;

public abstract class Order {
    private List<Pizza> pizzas;
    private List<String> drinks;
    private int orderNum;
    private static int orderCount = 1;
    private String address = null;

    public Order(List<Pizza> pizzas, List<String> drinks) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.orderNum = orderCount;
        orderCount += 1;
        if (orderCount > 1000) {
            orderCount = 1;
        }
    }

    public abstract String getType();

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<String> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<String> drinks) {
        this.drinks = drinks;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
