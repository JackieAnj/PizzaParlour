package a2;
import java.util.*;

import static a2.Menu.displayMenu;
import static a2.Menu.setMenu;

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


    public static Drink getDrinksLoop() {
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
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("[Enter a number or type 'Cancel']");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            }
            else if (isInteger(userInput)) {
                quantity = Integer.valueOf(userInput);
                break;
            }
        }

        return new Drink(name, quantity);
    }


    public static Pizza getPizzasLoop() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("How many pizzas do you want? Enter a number or 'Cancel'");
            userInput = scanner.nextLine().trim();
            if (userInput.equals("Cancel")) {
                return null;
            } else if (isInteger(userInput)) {
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


    public static Order createOrder() {
        List<Pizza> pizzas = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        String address;
        String type;

        Scanner newOrderScanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.println("What would you like to order? Enter one of the following commands:");
            System.out.println("[Pizza, Drink, Checkout, Cancel]");
            userInput = newOrderScanner.nextLine().trim();

            if (userInput.equals("Pizza")) {
                Pizza nextPizza = getPizzasLoop();
                if (nextPizza != null) {
                    pizzas.add(nextPizza);
                }
            } else if (userInput.equals("Drink")) {
                Drink nextDrink = getDrinksLoop();
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


    public static void runApp() {
        List<Order> orders = new ArrayList<>();
        Scanner orderScanner = new Scanner(System.in);
        System.out.println("Welcome to 301 Pizza!: ");
        String userInput;

        while (true) {
            System.out.println("What would you like to do? Enter a number for the corresponding option:");
            System.out.println("[(1) Create an Order, (2) Update an Order, (3) Delete an Order, (4) Submit an Order, (5) View Menu, (6) Quit App]");
            userInput = orderScanner.nextLine().trim();

            if (userInput.equals("1")) {
                Order newOrder = createOrder();
                if (newOrder != null) {
                    orders.add(newOrder);
                }
            } else if (userInput.equals("2")) {
                //
            } else if (userInput.equals("3")) {
                //
            } else if (userInput.equals("4")) {
                //
            } else if (userInput.equals("5")) {
                //
            } else if (userInput.equals("6")) {
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