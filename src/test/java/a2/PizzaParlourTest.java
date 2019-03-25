package a2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PizzaParlourTest {

    @Test
    public void TestGetPepperoniPizza() {
        String input = "M" + System.getProperty("line.separator") + "Pepperoni" + System.getProperty("line.separator") + "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();

        Pizza resultPizza = p.getPizzasLoop(new Scanner(System.in));
        List<String> toppings = new ArrayList<>();
        toppings.add("Pepperoni");
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
        toppings.add("Tomatoes");
        toppings.add("Olives");
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
        toppings.add("Tomatoes");
        toppings.add("Olives");
        toppings.add("Mushrooms");
        toppings.add("Jalapenos");
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
        toppings.add("Tomatoes");
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
    public void TestSubmitPickupOrder() {
        String input = "1" + System.getProperty("line.separator") + "Drink" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") +
                "5" + System.getProperty("line.separator") + "Checkout" + System.getProperty("line.separator") +
                "Pickup" + System.getProperty("line.separator") + "4" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") + "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setOut(ps);
        PizzaParlour p = new PizzaParlour();

        PizzaParlour.main(null);
        String expected = "What would you like to do? Enter a number for the corresponding option:";
        String result[] = baos.toString().split("\\r?\\n");
        assertEquals("Order type should be expected", expected, result[29]);
    }


    @Test
    public void TestSubmitDeliveryOrder() {
        List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        Pizza pizza = PizzaFactory.makePepperoniPizza('S', 3);
        Drink drink = new Drink("Coke", 1);
        pizzas.add(pizza);
        drinks.add(drink);
        PizzaParlour p = new PizzaParlour();
        Order order = OrderFactory.getOrder(pizzas, drinks, "15 College St", "Delivery");
        String expectedMsg = "Your order #" + order.getOrderNum() + " will be delivered as soon as possible to: 15 College St!";
        assertEquals("should display correct message", expectedMsg, p.submitDelivery(order));
    }

    @Test
    public void TestSubmitFoodoraOrder() {
        List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        Pizza pizza = PizzaFactory.makePepperoniPizza('S', 3);
        Drink drink = new Drink("Coke", 1);
        pizzas.add(pizza);
        drinks.add(drink);
        PizzaParlour p = new PizzaParlour();
        Order order = OrderFactory.getOrder(pizzas, drinks, "15 College St", "Foodora");
        String expectedMsg = "Address,15 College St\n" +
                "Order Details,Pizzas: [Pizza #" + pizza.getPizzaId() + " ---> type=Pepperoni && " +
                "size=S && " +
                "toppings=[Pepperoni] && " +
                "quantity=3" +
                "] & Drinks: [Drink #" + drink.getDrinkNum() + " ---> name=Coke && " +
                "quantity=1" +
                "]\n" +
                "Order Number," + order.getOrderNum() + "\n";
        assertEquals("should display correct message", expectedMsg, p.submitFoodora(order));
    }

    @Test
    public void TestSubmitUberOrder() {
        List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        Pizza pizza = PizzaFactory.makePepperoniPizza('S', 3);
        Drink drink = new Drink("Coke", 1);
        pizzas.add(pizza);
        drinks.add(drink);
        PizzaParlour p = new PizzaParlour();
        Order order = OrderFactory.getOrder(pizzas, drinks, "15 College St", "Uber");
        String expectedMsg = "{\"Address\":\"15 College St\",\"Order Details\":\"Pizzas: " +
                "[Pizza #" + pizza.getPizzaId() + " ---> type=Pepperoni && size=S && toppings=[Pepperoni] && quantity=3] & " +
                "Drinks: [Drink #" + drink.getDrinkNum() + " ---> name=Coke && quantity=1]\",\"Order Number\":" + order.getOrderNum() + "}";
        assertEquals("should display correct message", expectedMsg, p.submitUber(order));
    }

    @Test
    public void TestCallMenu() {
        String input = "5" + System.getProperty("line.separator") + "Full" + System.getProperty("line.separator") +
                "Done" + System.getProperty("line.separator") + "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        p.main(null);
    }

    @Test
    public void TestDeleteOrder() {
        String input = "1" + System.getProperty("line.separator") + "Drink" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") +
                "Checkout" + System.getProperty("line.separator") + "Pickup" + System.getProperty("line.separator") +
                "3" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") + "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        p.main(null);
    }

    @Test
    public void TestDeleteOrderCancel() {
        String input = "3" + System.getProperty("line.separator") + "Cancel" + System.getProperty("line.separator") + "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        p.main(null);
    }

    @Test
    public void TestGetUserAddress() {
        String input = "15 College St";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        String result = p.getUserAddress(new Scanner(System.in));
        assertEquals("Address should be expected", "15 College St", result);
    }

    @Test
    public void TestGetDrinkNumber() {
        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink("Coke", 1);
        drinks.add(drink);


        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        int result = p.getDrinkNumber(drinks, new Scanner(System.in));
        assertEquals("Drink number should be expected", 3, result);
    }


    @Test
    public void TestGetDrinkIndex() {
        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink("Coke", 1);
        drinks.add(drink);

        PizzaParlour p = new PizzaParlour();
        int result = p.getDrinkIndex(drinks, 3);
        assertEquals("Drink index should be expected", -1, result);
    }

    @Test
    public void TestUpdateDrinksAddCoke() {

        String input = "1" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator") + "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        List<Drink> result = p.updateDrinks(new ArrayList<>(), new Scanner(System.in));
        assertEquals("Drink type should be expected", "Coke", result.get(0).getName());
        assertEquals("Drink quantity should be expected", 1, result.get(0).getQuantity());
    }

    @Test
    public void TestRemoveCoke() {
        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink("Coke", 1);
        drinks.add(drink);

        String input = "2" + System.getProperty("line.separator") + drink.getDrinkNum() + System.getProperty("line.separator") + "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        List<Drink> result = p.updateDrinks(drinks, new Scanner(System.in));
        assertEquals("Coke should be removed", new ArrayList<>(), result);
    }

    @Test
    public void TestUpdateCoke() {
        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink("Coke", 1);
        drinks.add(drink);

        String input = "3" + System.getProperty("line.separator") + drink.getDrinkNum() + System.getProperty("line.separator")
                + "7" + System.getProperty("line.separator") + "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        List<Drink> result = p.updateDrinks(drinks, new Scanner(System.in));
        assertEquals("Coke quantity should be expected", 7, result.get(0).getQuantity());
    }

    @Test
    public void TestAddPepperoniPizza() {
        String input = "1" + System.getProperty("line.separator") + "S" + System.getProperty("line.separator")
                + "Pepperoni" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator") + "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        List<Pizza> result = p.updatePizzas(new ArrayList<>(), new Scanner(System.in));
        assertEquals("Pizza type should be expected", "Pepperoni", result.get(0).getType());
        assertEquals("Pizza size should be expected", 'S', result.get(0).getSize());
        assertEquals("Pizza quantity should be expected", 1, result.get(0).getQuantity());
    }

    @Test
    public void TestRemovePizza() {
        List<Pizza> pizzas = new ArrayList<>();
        Pizza pizza = PizzaFactory.makePepperoniPizza('S', 1);
        pizzas.add(pizza);

        String input = "2" + System.getProperty("line.separator") + pizza.getPizzaId() + System.getProperty("line.separator") + "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        List<Pizza> result = p.updatePizzas(pizzas, new Scanner(System.in));
        assertEquals("Pizza should be removed", new ArrayList<>(), result);
    }

    @Test
    public void TestUpdatePizza() {
        List<Pizza> pizzas = new ArrayList<>();
        Pizza pizza = PizzaFactory.makePepperoniPizza('M', 1);
        pizzas.add(pizza);

        String input = "3" + System.getProperty("line.separator") + pizza.getPizzaId() + System.getProperty("line.separator") + "S"
                + System.getProperty("line.separator") + "3" + System.getProperty("line.separator") + "Keep" + System.getProperty("line.separator")
                + "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PizzaParlour p = new PizzaParlour();
        List<Pizza> result = p.updatePizzas(pizzas, new Scanner(System.in));
        assertEquals("Pizza size should be updated", 'S', result.get(0).getSize());
        assertEquals("Pizza quantity should be updated", 3, result.get(0).getQuantity());
        assertEquals("Pizza type should be the same", "Pepperoni", result.get(0).getType());
    }

    @Test
    public void TestGetUpdatedOrderDone() {
        List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        Pizza pizza = PizzaFactory.makePepperoniPizza('S', 3);
        Drink drink = new Drink("Coke", 1);
        pizzas.add(pizza);
        drinks.add(drink);
        PizzaParlour p = new PizzaParlour();

        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Order order = OrderFactory.getOrder(pizzas, drinks, "15 College St", "Uber");
        assertEquals("Order should be the same", order,  p.getUpdatedOrder(order, new Scanner(System.in)));
    }
}
