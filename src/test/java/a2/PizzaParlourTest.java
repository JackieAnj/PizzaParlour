package a2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PizzaParlourTest {

    @Test
    public void TestGetPepperoniPizza() {
        String input = "M" + System.getProperty("line.separator") + "Pepperoni" + System.getProperty("line.separator") + "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop();
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

        Pizza resultPizza = p.getPizzasLoop();
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

        Pizza resultPizza = p.getPizzasLoop();
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

        Pizza resultPizza = p.getPizzasLoop();
        List<String> toppings = new ArrayList<>();
        toppings.add("tomatoes");
        assertEquals("Pizza size should be expected", 'S', resultPizza.getSize());
        assertEquals("Pizza type should be expected", "Neapolitan", resultPizza.getType());
        assertEquals("Pizza toppings should be expected", toppings, resultPizza.getToppings());
        assertEquals("Pizza quantity should be expected", 2, resultPizza.getQuantity());
    }

    @Test
    public void TestCustomPizza() {
        String input = "S" + System.getProperty("line.separator") + "Custom" + System.getProperty("line.separator") + "Chicken" + System.getProperty("line.separator") + "Beef" + System.getProperty("line.separator") + "Done" + System.getProperty("line.separator") + "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop();
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

        Drink resultDrink = p.getDrinksLoop();
        assertEquals("Drink type should be expected", "Coke", resultDrink.getName());
        assertEquals("Drink quantity should be expected", 5, resultDrink.getQuantity());
    }

}
