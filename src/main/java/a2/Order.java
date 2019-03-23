package a2;

import java.util.List;

public abstract class Order {
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private int orderNum;
    private static int orderCount = 1;
    private String address;

    public Order(List<Pizza> pizzas, List<Drink> drinks, String address) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.orderNum = orderCount;
        orderCount += 1;
        if (orderCount > 1000) {
            orderCount = 1;
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order #" + orderNum + " ---> " +
                "pizzas=" + pizzas + "\n" +
                "drinks=" + drinks + "\n" +
                "address=" + address + "\n";
    }

    public abstract String getType();

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    int getOrderNum() {
        return orderNum;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }
}
