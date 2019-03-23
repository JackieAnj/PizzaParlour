package a2;
import java.io.StringWriter;
import java.util.*;

import static a2.Menu.displayMenu;
import static a2.Menu.setMenu;

import org.json.JSONObject;

public class PizzaParlour {

    public static boolean isInteger(String possibleInt) throws NumberFormatException, NullPointerException {
        // CREDIT: https://www.baeldung.com/java-check-string-number
        try {
            Integer.parseInt(possibleInt);
        }
        catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isPositiveInteger(String possiblePosInt) {
        return isInteger(possiblePosInt) && Integer.valueOf(possiblePosInt) > 0;
    }


    public static Drink getDrinksLoop(Scanner scanner) {
        Map<String, String> validDrinks = new HashMap<>();
        validDrinks.put("1", "Coke");
        validDrinks.put("2", "Diet Coke");
        validDrinks.put("3", "Coke Zero");
        validDrinks.put("4", "Pepsi");
        validDrinks.put("5", "Diet Pepsi");
        validDrinks.put("6", "Dr. Pepper");
        validDrinks.put("7", "Water");
        validDrinks.put("8", "Juice");
        validDrinks.put("9", "Cancel");
        String userInput;

        while (true) {
            System.out.println("What drink do you want? Enter a number for the corresponding drink:");
            System.out.println("[(1) Coke, (2) Diet Coke, (3) Coke Zero, (4) Pepsi, (5) Diet Pepsi, (6) Dr. Pepper, (7) Water, (8) Juice, (9) Cancel]");
            userInput = scanner.nextLine().trim();
            if (validDrinks.containsKey(userInput)) {
                if (userInput.equals("9")) {
                    return null;
                }
                break;
            }
        }
        String name = validDrinks.get(userInput);

        Integer quantity = 0;
        while (true) {
            System.out.println("How many of this drink do you want?");
            System.out.println("[Enter a number > 0 or type 'Cancel']");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            }
            else if (isPositiveInteger(userInput)) {
                quantity = Integer.valueOf(userInput);
                break;
            }
        }

        return new Drink(name, quantity);
    }


    public static Pizza getPizzasLoop(Scanner scanner) {
        List<String> validSizes = new ArrayList<>(Arrays.asList("S", "M", "L", "Cancel"));
        List<String> validTypes = new ArrayList<>(Arrays.asList("Pepperoni", "Margherita", "Vegetarian", "Neapolitan", "Custom", "Cancel"));
        List<String> validToppings = new ArrayList<>(Arrays.asList("Olives", "Tomatoes", "Mushrooms", "Jalapenos", "Chicken", "Beef", "Pepperoni", "Undo", "Done", "Cancel"));
        String userInput;

        char size;
        while (true) {
            System.out.println("What size pizza do you want? Enter one of the following commands:");
            System.out.println("[S, M, L, Cancel]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            } else if (validSizes.contains(userInput)) {
                break;
            }
        }
        size = userInput.charAt(0);

        String type;
        while (true) {
            System.out.println("What type of pizza do you want?");
            System.out.println("[Pepperoni, Margherita, Vegetarian, Neapolitan, Custom, Cancel]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            } else if (validTypes.contains(userInput)) {
                break;
            }
        }
        type = userInput;

        List<String> toppings = new ArrayList<String>();
        if (type.equals("Custom")) {
            String next_topping = "SENTINEL";
            while (!next_topping.equals("Done")) {
                System.out.println("Pick a topping! [Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni, Undo, Done, Cancel]");
                next_topping = scanner.nextLine().trim();
                if (next_topping.equals("Cancel")) {
                    return null;
                } else if (next_topping.equals("Done")) {
                    break;
                } else if (next_topping.equals("Undo")) {
                    if (toppings.size() > 0) {
                        toppings.remove(toppings.size() - 1);
                    }
                } else if (validToppings.contains(next_topping)) {
                    toppings.add(next_topping);
                }
            }
        }

        int quantity;
        while (true) {
            System.out.println("How many pizzas do you want? Enter a number > 0 or 'Cancel'");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            } else if (isPositiveInteger(userInput)) {
                break;
            }
        }
        quantity = Integer.parseInt(userInput);

        Pizza customerPizza = null;
        if (type.equals("Pepperoni")) {
            customerPizza = PizzaFactory.makePepperoniPizza(size, quantity);
        } else if (type.equals("Margherita")) {
            customerPizza = PizzaFactory.makeMargheritaPizza(size, quantity);
        } else if (type.equals("Vegetarian")) {
            customerPizza = PizzaFactory.makeVegetarianPizza(size, quantity);
        } else if (type.equals("Neapolitan")) {
            customerPizza = PizzaFactory.makeNeapolitanPizza(size, quantity);
        } else if (type.equals("Custom")) {
            customerPizza = PizzaFactory.makeCustomPizza(size, quantity, toppings);
        }

        return customerPizza;
    }


    public static String[] getAddressAndDelivery() {
        String[] addressAndDelivery = new String[2];
        List<String> validDeliveries = new ArrayList<>(Arrays.asList("Pickup", "Delivery", "Uber", "Foodora"));
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.println("What delivery type do you want? Option 2 uses our parlour's own delivery system.");
            System.out.println("[Pickup, Delivery, Uber, Foodora, Cancel]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            } else if (validDeliveries.contains(userInput)) {
                break;
            }
        }
        addressAndDelivery[1] = userInput;

        if (!addressAndDelivery[1].equals("Pickup")) {
            System.out.println("Please enter your address:");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            }
            addressAndDelivery[0] = userInput;
        }

        return addressAndDelivery;
    }


    public static Order createOrder(Scanner newOrderScanner) {
        List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        String address;
        String type;

        String userInput;

        while (true) {
            System.out.println("What would you like to order? Enter one of the following commands:");
            System.out.println("[Pizza, Drink, Checkout, Cancel]");
            userInput = newOrderScanner.nextLine().trim();

            if (userInput.equals("Pizza")) {
                Pizza nextPizza = getPizzasLoop(newOrderScanner);
                if (nextPizza != null) {
                    pizzas.add(nextPizza);
                }
            } else if (userInput.equals("Drink")) {
                Drink nextDrink = getDrinksLoop(newOrderScanner);
                if (nextDrink != null) {
                    drinks.add(nextDrink);
                }
            } else if (userInput.equals("Checkout")) {
                String[] addressAndDelivery = getAddressAndDelivery();
                if (addressAndDelivery == null) {
                    return null;
                }
                address = addressAndDelivery[0];
                type = addressAndDelivery[1];
                break;
            } else if (userInput.equals("Cancel")){
                return null;
            }
        }

        return OrderFactory.getOrder(pizzas, drinks, address, type);
    }


    public static int getOrderNumber(List<Order> orders, Scanner scanner) {
        for (int i = 0; i < orders.size(); i += 1) {
            System.out.println(orders.get(i));
        }
        System.out.println("Choose an order number or 'Cancel':");
        String userInput = scanner.nextLine().trim();
        if (userInput.equals("Cancel") || !isPositiveInteger(userInput)) {
            return -1;
        }
        return Integer.valueOf(userInput);
    }


    public static int getOrderIndex(List<Order> orders, int orderNumber) {
        for (int i = 0; i < orders.size(); i += 1) {
            if (orders.get(i).getOrderNum() == orderNumber) {
                return i;
            }
        }
        return -1;
    }


    public static String getMenuCommandFromUser(Scanner scanner) {
        System.out.println("Enter one of the following commands:");
        System.out.println("'Full': the full menu");
        System.out.println("'Pizzas': the pizzas");
        System.out.println("'Toppings': the toppings");
        System.out.println("'Drinks': the drinks");
        System.out.println("You can also get an individual item such as 'Coke' or 'Beef'");
        System.out.println("Type 'Done' to exit the menu");
        return scanner.nextLine().trim();
    }


    public static String getMenuInfo(String command) {
        return displayMenu("Menu-" + command);
    }


    public static String submitPickup(Order order) {
        String result = "Your order will be available for pickup in 15 to 20 minutes. You are order #";
        result += String.valueOf(order.getOrderNum());
        result += "!";
        return result;
    }


    public static String submitDelivery(Order order) {
        String result = "Your order #" + String.valueOf(order.getOrderNum()) + " will be delivered as soon as possible to: ";
        result += order.getAddress();
        result += "!";
        return result;
    }


    public static String submitUber(Order order) {
        JSONObject orderJson = new JSONObject();
        orderJson.put("Address", order.getAddress());
        orderJson.put("Order Number", order.getOrderNum());
        String pizzas = order.getPizzas().toString();
        String drinks = order.getDrinks().toString();
        String orderDetails = "Pizzas: " + pizzas + " & " + "Drinks: " + drinks;
        orderJson.put("Order Details", orderDetails);
        return orderJson.toString();
    }


    public static String submitFoodora(Order order) {
        // Create comma separated line for each part of delivery details
        String result = "";
        String address = "Address," + order.getAddress() + "\n";
        String pizzas = order.getPizzas().toString();
        String drinks = order.getDrinks().toString();
        String foodDetails = "Pizzas: " + pizzas + " & " + "Drinks: " + drinks;
        String orderDetails = "Order Details," + foodDetails + "\n";
        String orderNumber = "Order Number," + order.getOrderNum() + "\n";
        result += address;
        result += orderDetails;
        result += orderNumber;
        return result;
    }


    public static String getUserAddress(Scanner scanner) {
        System.out.println("Please enter your address:");
        return scanner.nextLine().trim();
    }


    public static int getDrinkNumber(List<Drink> drinks, Scanner scanner) {
        for (int i = 0; i < drinks.size(); i += 1) {
            System.out.println(drinks.get(i));
        }
        System.out.println("Choose a drink number or 'Cancel':");
        String userInput = scanner.nextLine().trim();
        if (userInput.equals("Cancel") || !isPositiveInteger(userInput)) {
            return -1;
        }
        return Integer.valueOf(userInput);
    }


    public static int getDrinkIndex(List<Drink> drinks, int drinkNumber) {
        for (int i = 0; i < drinks.size(); i += 1) {
            if (drinks.get(i).getDrinkNum() == drinkNumber) {
                return i;
            }
        }
        return -1;
    }


    public static Drink changeDrink(Drink drink, Scanner scanner) {
        System.out.println(drink);
        System.out.println("Enter a new quantity [provide a number > 0]:");
        String userInput = scanner.nextLine().trim();
        if (isPositiveInteger(userInput) && Integer.valueOf(userInput) > 0) {
            drink.setQuantity(Integer.valueOf(userInput));
        }
        return drink;
    }


    public static List<Drink> updateDrinks(List<Drink> drinks, Scanner scanner) {
        String userInput = "";
        while (!userInput.equals("4")) {
            System.out.println("Enter a number for the corresponding command:");
            System.out.println("[(1) Add Drink, (2) Remove Drink, (3) Change Drink, (4) Done]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("1")) {
                Drink drink = getDrinksLoop(scanner);
                drinks.add(drink);
            } else if (userInput.equals("2")) {
                int drinkNumber = getDrinkNumber(drinks, scanner);
                if (drinkNumber != -1) {
                    int drinkIndex = getDrinkIndex(drinks, drinkNumber);
                    if (drinkIndex != -1) {
                        drinks.remove(drinkIndex);
                    }
                }
            } else if (userInput.equals("3")) {
                int drinkNumber = getDrinkNumber(drinks, scanner);
                if (drinkNumber != -1) {
                    int drinkIndex = getDrinkIndex(drinks, drinkNumber);
                    if (drinkIndex != -1) {
                        Drink drink = drinks.get(drinkIndex);
                        Drink newDrink = changeDrink(drink, scanner);
                        drinks.set(drinkIndex, newDrink);
                    }
                }
            }
        }
        return drinks;
    }


    public static int getPizzaNumber(List<Pizza> pizzas, Scanner scanner) {
        for (int i = 0; i < pizzas.size(); i += 1) {
            System.out.println(pizzas.get(i));
        }
        System.out.println("Choose a pizza number or 'Cancel':");
        String userInput = scanner.nextLine().trim();
        if (userInput.equals("Cancel") || !isPositiveInteger(userInput)) {
            return -1;
        }
        return Integer.valueOf(userInput);
    }


    public static int getPizzaIndex(List<Pizza> pizzas, int pizzaNumber) {
        for (int i = 0; i < pizzas.size(); i += 1) {
            if (pizzas.get(i).getPizzaId() == pizzaNumber) {
                return i;
            }
        }
        return -1;
    }


    public static Pizza changePizza(Pizza pizza, Scanner scanner) {
        System.out.println(pizza);
        List<String> validSizes = new ArrayList<>(Arrays.asList("S", "M", "L"));
        List<String> validTypes = new ArrayList<>(Arrays.asList("Pepperoni", "Margherita", "Vegetarian", "Neapolitan", "Custom"));
        List<String> validToppings = new ArrayList<>(Arrays.asList("Olives", "Tomatoes", "Mushrooms", "Jalapenos", "Chicken", "Beef", "Pepperoni", "Undo", "Done"));
        String userInput;

        char size = pizza.getSize();
        int quantity = pizza.getQuantity();
        String type = pizza.getType();
        List<String> toppings = pizza.getToppings();

        System.out.println("What size pizza do you want?");
        System.out.println("[S, M, L, Keep]");
        System.out.println("Current: " + size);
        userInput = scanner.nextLine().trim();
        if (validSizes.contains(userInput) && !userInput.equals("Keep")) {
            size = userInput.charAt(0);
        }

        System.out.println("How many pizzas do you want? Enter a number > 0 or 'Keep'");
        System.out.println("Current: " + quantity);
        userInput = scanner.nextLine().trim();
        if (isPositiveInteger(userInput)) {
            quantity = Integer.parseInt(userInput);
        }


        System.out.println("What type of pizza do you want?");
        System.out.println("[Pepperoni, Margherita, Vegetarian, Neapolitan, Custom, Keep]");
        System.out.println("Current: " + type);
        userInput = scanner.nextLine().trim();
        if (validTypes.contains(userInput)) {
            type = userInput;
        }

        String next_topping = "SENTINEL";
        while (type.equals("Custom")) {
            System.out.println("Pick a topping! [Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni, Undo, Done, Clear]");
            System.out.println("Current: " + toppings);
            next_topping = scanner.nextLine().trim();
            if (next_topping.equals("Done")) {
                break;
            } else if (next_topping.equals("Undo")) {
                if (toppings.size() > 0) {
                    toppings.remove(toppings.size() - 1);
                }
            } else if (next_topping.equals("Clear")) {
                toppings.clear();
            } else if (validToppings.contains(next_topping)) {
                toppings.add(next_topping);
            }
        }

        Pizza customerPizza = null;
        if (type.equals("Pepperoni")) {
            customerPizza = PizzaFactory.makePepperoniPizza(size, quantity);
        } else if (type.equals("Margherita")) {
            customerPizza = PizzaFactory.makeMargheritaPizza(size, quantity);
        } else if (type.equals("Vegetarian")) {
            customerPizza = PizzaFactory.makeVegetarianPizza(size, quantity);
        } else if (type.equals("Neapolitan")) {
            customerPizza = PizzaFactory.makeNeapolitanPizza(size, quantity);
        } else if (type.equals("Custom")) {
            customerPizza = PizzaFactory.makeCustomPizza(size, quantity, toppings);
        }

        return customerPizza;
    }


    public static List<Pizza> updatePizzas(List<Pizza> pizzas, Scanner scanner) {
        String userInput = "";
        while (!userInput.equals("4")) {
            System.out.println("Enter a number for the corresponding command:");
            System.out.println("[(1) Add Pizza, (2) Remove Pizza, (3) Change Pizza, (4) Done]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("1")) {
                Pizza pizza = getPizzasLoop(scanner);
                pizzas.add(pizza);
            } else if (userInput.equals("2")) {
                int pizzaNumber = getPizzaNumber(pizzas, scanner);
                if (pizzaNumber != -1) {
                    int pizzaIndex = getPizzaIndex(pizzas, pizzaNumber);
                    if (pizzaIndex != -1) {
                        pizzas.remove(pizzaIndex);
                    }
                }
            } else if (userInput.equals("3")) {
                int pizzaNumber = getPizzaNumber(pizzas, scanner);
                if (pizzaNumber != -1) {
                    int pizzaIndex = getPizzaIndex(pizzas, pizzaNumber);
                    if (pizzaIndex != -1) {
                        Pizza pizza = pizzas.get(pizzaIndex);
                        Pizza newPizza = changePizza(pizza, scanner);
                        pizzas.set(pizzaIndex, newPizza);
                    }
                }
            }
        }
        return pizzas;
    }


    public static Order getUpdatedOrder(Order order, Scanner scanner) {
        List<Pizza> newPizzas = order.getPizzas();
        List<Drink> newDrinks = order.getDrinks();
        String newAddress = order.getAddress();
        String userInput = "";

        while (!userInput.equals("4")) {
            System.out.println("Enter a number for the corresponding command:");
            System.out.println("[(1) Update Pizzas, (2) Update Drinks, (3) Update Address, (4) Done]");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("1")) {
                newPizzas = updatePizzas(newPizzas, scanner);
            } else if (userInput.equals("2")) {
                newDrinks = updateDrinks(newDrinks, scanner);
            } else if (userInput.equals("3")) {
                newAddress = getUserAddress(scanner);
            }
        }

        order.setPizzas(newPizzas);
        order.setDrinks(newDrinks);
        order.setAddress(newAddress);
        return order;
    }


    public static void runApp() {
        setMenu();
        List<Order> orders = new ArrayList<>();
        Scanner orderScanner = new Scanner(System.in);
        System.out.println("Welcome to 301 Pizza!: ");
        String userInput;

        while (true) {
            System.out.println("What would you like to do? Enter a number for the corresponding option:");
            System.out.println("[(1) Create an Order, (2) Update an Order, (3) Delete an Order, (4) Submit an Order, (5) View Menu, (6) Quit App]");
            userInput = orderScanner.nextLine().trim();

            if (userInput.equals("1")) { // Create an Order
                Order newOrder = createOrder(orderScanner);
                if (newOrder != null) {
                    orders.add(newOrder);
                }
            } else if (userInput.equals("2")) { // Update an Order
                int orderToModify = getOrderNumber(orders, new Scanner(System.in));
                if (orderToModify != -1) {
                    int indexToModify = getOrderIndex(orders, orderToModify);
                    if (indexToModify != -1) {
                        Order order = orders.get(indexToModify);
                        Scanner scanner = new Scanner(System.in);
                        Order newOrder = getUpdatedOrder(order, scanner);
                    }
                }
            } else if (userInput.equals("3")) { // Delete an Order
                int orderToRemove = getOrderNumber(orders, new Scanner(System.in));
                if (orderToRemove != -1) {
                    int indexToRemove = getOrderIndex(orders, orderToRemove);
                    if (indexToRemove != -1) {
                        orders.remove(indexToRemove);
                    }
                }
            } else if (userInput.equals("4")) { // Submit an Order
                int orderToSubmit = getOrderNumber(orders, new Scanner(System.in));
                if (orderToSubmit != -1) {
                    int indexToSubmit = getOrderIndex(orders, orderToSubmit);
                    if (indexToSubmit != -1) {
                        Order order = orders.get(indexToSubmit);
                        String type = order.getType();
                        String result = "";
                        if (type.equals("Pickup")) {
                            result = submitPickup(order);
                        } else if (type.equals("Delivery")) {
                            result = submitDelivery(order);
                        } else if (type.equals("Uber")) {
                            result = submitUber(order);
                        } else if (type.equals("Foodora")) {
                            result = submitFoodora(order);
                        }
                        System.out.println(result);
                        orders.remove(indexToSubmit);
                    }
                    //
                    // DELETE ORDER AFTER SUBMITTED
                }
            } else if (userInput.equals("5")) { // View Menu
                String menuCommand = "";
                while (!menuCommand.equals("Done")) {
                    menuCommand = getMenuCommandFromUser(new Scanner(System.in));
                    String menuInfo = getMenuInfo(menuCommand);
                    System.out.println("RESULT BEGIN\n" + menuInfo + "RESULT END\n");
                }
            } else if (userInput.equals("6")) { // Quit App
                break;
            } else {
                System.out.println("Invalid Command, Try Again.");
            }
            // DEVELOPMENT ONLY
            System.out.println(orders);
        }
    }


    public static void main(String[] args) {
        runApp();
    }

}