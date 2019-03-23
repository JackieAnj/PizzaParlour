package a2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PizzaParlourTest {

    @Test
    public void TestGetPepperoniPizza() {
        String input = "M" + System.getProperty("line.separator") + "Pepperoni" + System.getProperty("line.separator") + "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop(new Scanner(System.in));
        List<String> toppings = new ArrayList<>();
        toppings.add("pepperoni");
        assertEquals("Pizza size should be expected", 'M', resultPizza.getSize());
        assertEquals("Pizza type should be expected", "Pepperoni", resultPizza.getType());
        assertEquals("Pizza toppings should be expected", toppings, resultPizza.getToppings());
        assertEquals("Pizza quantity should be expected", 12, resultPizza.getQuantity());
    }

    @Test
    public void TestGetMarghertaPizza() {
        String input = "S" + System.getProperty("line.separator") + "Margherita" + System.getProperty("line.separator") + "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop(new Scanner(System.in));
        List<String> toppings = new ArrayList<>();
        toppings.add("tomatoes");
        toppings.add("olives");
        assertEquals("Pizza size should be expected", 'S', resultPizza.getSize());
        assertEquals("Pizza type should be expected", "Margherita", resultPizza.getType());
        assertEquals("Pizza toppings should be expected", toppings, resultPizza.getToppings());
        assertEquals("Pizza quantity should be expected", 2, resultPizza.getQuantity());
    }

    @Test
    public void TestGetVegetarianPizza() {
        String input = "L" + System.getProperty("line.separator") + "Vegetarian" + System.getProperty("line.separator") + "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop(new Scanner(System.in));
        List<String> toppings = new ArrayList<>();
        toppings.add("tomatoes");
        toppings.add("olives");
        toppings.add("mushrooms");
        toppings.add("jalapenos");
        assertEquals("Pizza size should be expected", 'L', resultPizza.getSize());
        assertEquals("Pizza type should be expected", "Vegetarian", resultPizza.getType());
        assertEquals("Pizza toppings should be expected", toppings, resultPizza.getToppings());
        assertEquals("Pizza quantity should be expected", 3, resultPizza.getQuantity());
    }

    @Test
    public void TestGetNeapolitanPizza() {
        String input = "S" + System.getProperty("line.separator") + "Neapolitan" + System.getProperty("line.separator") + "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop(new Scanner(System.in));
        List<String> toppings = new ArrayList<>();
        toppings.add("tomatoes");
        assertEquals("Pizza size should be expected", 'S', resultPizza.getSize());
        assertEquals("Pizza type should be expected", "Neapolitan", resultPizza.getType());
        assertEquals("Pizza toppings should be expected", toppings, resultPizza.getToppings());
        assertEquals("Pizza quantity should be expected", 2, resultPizza.getQuantity());
    }

    @Test
    public void TestCustomPizza() {
        String input = "S" + System.getProperty("line.separator") + "Custom" + System.getProperty("line.separator") +
                "Chicken" + System.getProperty("line.separator") + "Beef" + System.getProperty("line.separator") +
                "Done" + System.getProperty("line.separator") + "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop(new Scanner(System.in));
        List<String> toppings = new ArrayList<>();
        toppings.add("Chicken");
        toppings.add("Beef");
        assertEquals("Pizza size should be expected", 'S', resultPizza.getSize());
        assertEquals("Pizza type should be expected", "Custom", resultPizza.getType());
        assertEquals("Pizza toppings should be expected", toppings, resultPizza.getToppings());
        assertEquals("Pizza quantity should be expected", 2, resultPizza.getQuantity());
    }

    @Test
    public void TestGetCoke() {
        String input = "1" + System.getProperty("line.separator") + "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Drink resultDrink = p.getDrinksLoop(new Scanner(System.in));
        assertEquals("Drink type should be expected", "Coke", resultDrink.getName());
        assertEquals("Drink quantity should be expected", 5, resultDrink.getQuantity());
        assertEquals("Drink String should be expected", "Drink{name='Coke', quantity=5}", resultDrink.toString());
    }

    @Test
    public void TestCreatePickupOrder() {
        String input = "Pizza" + System.getProperty("line.separator") + "M" + System.getProperty("line.separator") +
                "Pepperoni" + System.getProperty("line.separator") + "12" + System.getProperty("line.separator") +
                "Checkout" + System.getProperty("line.separator") + "Pickup";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Order resultOrder = p.createOrder(new Scanner(System.in));
        List<Pizza> Pizzas = resultOrder.getPizzas();
        Pizza customerPizza = PizzaFactory.makePepperoniPizza('M', 12);
        Pizza resultPizza = Pizzas.get(0);
        assertEquals("Order type should be expected", "Pickup", resultOrder.getType());
        assertEquals("Order pizza should be expected", customerPizza.getQuantity(), resultPizza.getQuantity());
        assertEquals("Order pizza should be expected", customerPizza.getSize(), resultPizza.getSize());
        assertEquals("Order pizza should be expected", customerPizza.getToppings(), resultPizza.getToppings());
        assertEquals("Order drinks should be expected", new ArrayList<>(), resultOrder.getDrinks());
        assertEquals("Order address should be expected", "309 Pizza Parlour", resultOrder.getAddress());
    }

    @Test
    public void TestCreateDeliveryOrder() {
        String input = "Drink" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") +
                "5" + System.getProperty("line.separator") + "Checkout" + System.getProperty("line.separator") +
                "Delivery" + System.getProperty("line.separator") + "100 Jane St";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Order resultOrder = p.createOrder(new Scanner(System.in));

        assertEquals("Order type should be expected", "Delivery", resultOrder.getType());
        assertEquals("Order address should be expected", "100 Jane St", resultOrder.getAddress());
    }

    @Test
    public void TestCreateFoodoraOrder() {
        String input = "Drink" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") +
                "5" + System.getProperty("line.separator") + "Checkout" + System.getProperty("line.separator") +
                "Foodora" + System.getProperty("line.separator") + "20 Younge St";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Order resultOrder = p.createOrder(new Scanner(System.in));

        assertEquals("Order type should be expected", "Foodora", resultOrder.getType());
        assertEquals("Order address should be expected", "20 Younge St", resultOrder.getAddress());
    }

    @Test
    public void TestCreateUberOrder() {
        String input = "Drink" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") +
                "5" + System.getProperty("line.separator") + "Checkout" + System.getProperty("line.separator") +
                "Uber" + System.getProperty("line.separator") + "15 College St";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Order resultOrder = p.createOrder(new Scanner(System.in));

        assertEquals("Order type should be expected", "Uber", resultOrder.getType());
        assertEquals("Order address should be expected", "15 College St", resultOrder.getAddress());
    }

    @Test
    public void TestDeleteOrder() {
        String input = "5" + System.getProperty("line.separator") + "Full" + System.getProperty("line.separator") +
                "Done" + System.getProperty("line.separator") + "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        p.main(null);

    }
}
