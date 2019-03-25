package a2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static a2.Menu.displayMenu;
import static a2.Menu.getTotal;
import static a2.Menu.setMenu;
import static org.junit.Assert.*;

public class MenuTest {

    @org.junit.Before
    public void setUp() {
        setMenu();
    }

    @Test
    public void NotValidItem() {
        String actual = displayMenu("Menu-IDK");
        String expected =  "IDK is not a valid menu item";
        assertEquals("invalid item message should be displayed", expected, actual);
    }

    @Test
    public void testPizzasMenu() {
        String actual = displayMenu("Menu-Pizzas");
        String expected = "== PIZZAS ==============================\n" +
                "Margherita Pizza ==> (Tomatoes, Olives) S: $6.50 M: $8.50 L: $10.50\n" +
                "Neapolitan Pizza ==> (Tomatoes) S: $6.25 M: $8.25 L: $10.25\n" +
                "Custom Pizza ==> S: $6.00 M: $8.00 L: $10.00\n" +
                "Vegetarian Pizza ==> (Tomatoes, Olives, Mushrooms, Jalapenos) S: $7.00 M: $9.00 L: $11.00\n" +
                "Pepperoni Pizza ==> (pepperoni) S: $6.25 M: $8.25 L: $10.25\n";
        assertEquals("pizza menu should be as expected", expected, actual);
    }

    @Test
    public void testToppingsMenu() {
        String actual = displayMenu("Menu-Toppings");
        String expected =  " == TOPPINGS ==============================\n" +
                "Mushrooms ==> $0.50\n" +
                "Olives ==> $0.50\n" +
                "Jalapenos ==> $0.50\n" +
                "Chicken ==> $0.50\n" +
                "Tomatoes ==> $0.50\n" +
                "Beef ==> $0.50\n" +
                "Pepperoni ==> $0.50\n";
        assertEquals("Toppings menu should be as expected", expected, actual);
    }

    @Test
    public void testDrinksMenu() {
        String actual = displayMenu("Menu-Drinks");
        String expected =  "== DRINKS ==============================\n" +
                "Water ==> $1.00\n" +
                "Diet Coke ==> $1.00\n" +
                "Dr. Pepper ==> $1.00\n" +
                "Coke ==> $1.00\n" +
                "Pepsi ==> $1.00\n" +
                "Juice ==> $1.50\n" +
                "Diet Pepsi ==> $1.00\n" +
                "Coke Zero ==> $1.00\n";
        assertEquals("Drinks menu should be as expected", expected, actual);
    }

    @Test
    public void testFullMenu() {
        String actual = displayMenu("Menu-Full");
        String expected =  "== PIZZAS ==============================\n" +
                "Margherita Pizza ==> (Tomatoes, Olives) S: $6.50 M: $8.50 L: $10.50\n" +
                "Neapolitan Pizza ==> (Tomatoes) S: $6.25 M: $8.25 L: $10.25\n" +
                "Custom Pizza ==> S: $6.00 M: $8.00 L: $10.00\n" +
                "Vegetarian Pizza ==> (Tomatoes, Olives, Mushrooms, Jalapenos) S: $7.00 M: $9.00 L: $11.00\n" +
                "Pepperoni Pizza ==> (pepperoni) S: $6.25 M: $8.25 L: $10.25\n" +
                " == TOPPINGS ==============================\n" +
                "Mushrooms ==> $0.50\n" +
                "Olives ==> $0.50\n" +
                "Jalapenos ==> $0.50\n" +
                "Chicken ==> $0.50\n" +
                "Tomatoes ==> $0.50\n" +
                "Beef ==> $0.50\n" +
                "Pepperoni ==> $0.50\n" +
                "== DRINKS ==============================\n" +
                "Water ==> $1.00\n" +
                "Diet Coke ==> $1.00\n" +
                "Dr. Pepper ==> $1.00\n" +
                "Coke ==> $1.00\n" +
                "Pepsi ==> $1.00\n" +
                "Juice ==> $1.50\n" +
                "Diet Pepsi ==> $1.00\n" +
                "Coke Zero ==> $1.00\n";
        assertEquals("Full menu should be as expected", expected, actual);
    }

    @Test
    public void testPepperoniPizza() {
        String actual = displayMenu("Menu-Pepperoni Pizza");
        String expected = "Pepperoni Pizza ==> (pepperoni) S: $6.25 M: $8.25 L: $10.25";
        assertEquals("Pepperoni Pizza should be as expected", expected, actual);
    }

    @Test
    public void testCoke() {
        String actual = displayMenu("Menu-Coke");
        String expected = "Coke ==> $1.00";
        assertEquals("Coke should be as expected", expected, actual);
    }
    @Test
    public void testMushroomsTopping() {
        String actual = displayMenu("Menu-Mushrooms");
        String expected = "Mushrooms ==> $0.50";
        assertEquals("Mushrooms should be as expected", expected, actual);
    }

    @Test
    public void testGetTotalPepperoniPizza() {
        Pizza pepperoniPizza = PizzaFactory.makePepperoniPizza('S', 2);
        Drink dietCoke = new Drink("Diet Coke", 1);
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pepperoniPizza);
        List<Drink> drinks = new ArrayList<>();
        drinks.add(dietCoke);
        Order order = OrderFactory.getOrder(pizzas, drinks, "uoft", "Pickup");
        assert order != null;
        String price = getTotal(order);
        assertEquals("Total: $13.5", price);
    }

    @Test
    public void testGetTotalCustomPizza() {
        List<String> toppings = new ArrayList<>();
        toppings.add("Jalapenos");
        toppings.add("Chicken");
        toppings.add("Beef");
        Pizza customPizza = PizzaFactory.makeCustomPizza('L', 3, toppings);
        Drink dietCoke = new Drink("Diet Coke", 1);
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(customPizza);
        List<Drink> drinks = new ArrayList<>();
        drinks.add(dietCoke);
        Order order = OrderFactory.getOrder(pizzas, drinks, "uoft", "Pickup");
        assert order != null;
        String price = getTotal(order);
        assertEquals("Total: $35.5", price);
    }

    @Test
    public void testGetTotalMixedOrder() {
        //
    }

}