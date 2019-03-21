package a2;
import java.util.*;

public class PizzaParlour {

    public static int[] getDrinksLoop(Map<Integer, Integer> drinks) {
        int[] drinkAndNumber = new int[2];
        System.out.println("What drink do you want? [(1) Coke, (2) Diet Coke, (3) Coke Zero, (4) Pepsi, (5) Diet Pepsi, (6) Dr. Pepper, (7) Water, (8) Juice, (9) Back]");
        Scanner scanner = new Scanner(System.in);
        Integer userDrinkIndex = Integer.valueOf(scanner.nextLine().trim());

        while (!drinks.containsKey(userDrinkIndex) && !userDrinkIndex.equals(9)) {
            System.out.println("NOT VALID");
            System.out.println("What drink do you want? [(1) Coke, (2) Diet Coke, (3) Coke Zero, (4) Pepsi, (5) Diet Pepsi, (6) Dr. Pepper, (7) Water, (8) Juice, (9) Back]");
            userDrinkIndex = Integer.valueOf(scanner.nextLine().trim());
        }

        if (userDrinkIndex.equals(9)) {
            drinkAndNumber[0] = 0;
            drinkAndNumber[1] = 0;
            return drinkAndNumber;
        }

        System.out.println("How many of this drink? [Enter number or 'Back']");
        Integer numDrinks = Integer.valueOf(scanner.nextLine().trim()); // WARNING: INPUT NEEDS TO BE VERIFIED !!!!!!!!!!!!!!!!!!!!!!!!!!
        drinkAndNumber[0] = userDrinkIndex;
        drinkAndNumber[1] = numDrinks;
        return drinkAndNumber;
    }

    public static boolean isInteger(String possibleInt) throws NumberFormatException, NullPointerException {
        // CREDIT: https://www.baeldung.com/java-check-string-number
        try {
            Integer.parseInt(possibleInt);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    public static Pizza getPizzasLoop() {
        Scanner scanner = new Scanner(System.in);
        List<String> validSizes = new ArrayList<String>(Arrays.asList("S", "M", "L", "Cancel"));
        List<String> validTypes = new ArrayList<String>(Arrays.asList("Pepperoni", "Margherita", "Vegetarian", "Neapolitan", "Custom", "Cancel"));
        List<String> validToppings = new ArrayList<String>(Arrays.asList("Olives", "Tomatoes", "Mushrooms", "Jalapenos", "Chicken", "Beef", "Pepperoni", "Undo", "Done", "Cancel"));
        ////List<String> validNum = new ArrayList<String>(Arrays.asList("S", "M", "L", "Back"));

        char size;
        // What size pizza? [S, M, L, Back]
        String pizzaSize = "SENTINEL";
        while (!validSizes.contains(pizzaSize)) {
            System.out.println("What size pizza do you want? [S, M, L, Cancel]");
            pizzaSize = scanner.nextLine().trim();
        }
        if (pizzaSize.equals("Cancel")) {
            return null;
        }
        size = pizzaSize.charAt(0);

        String type;
        // What type of pizza? [Types..., Custom, Back]
        String pizzaType = "SENTINEL";
        while (!validTypes.contains(pizzaType)) {
            System.out.println("What type of pizza do you want? [Pepperoni, Margherita, Vegetarian, Neapolitan, Custom, Cancel]");
            pizzaType = scanner.nextLine().trim();
        }
        if (pizzaType.equals("Cancel")) {
            return null;
        }
        type = pizzaType;

        List<String> toppings = new ArrayList<String>();
        // What toppings? [Toppings..., Undo, Back, Done] (*: if custom)
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
        // How many of this pizza? [Num, Back]
        String pizzaQuantity = "SENTINEL";
        while (!isInteger(pizzaQuantity)) {
            System.out.println("How many pizzas do you want?");
            pizzaQuantity = scanner.nextLine().trim();
        }
        quantity = Integer.parseInt(pizzaQuantity);

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

    public static void main(String[] args) {

        Map<Integer, Integer> drinks = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 8; i += 1) {
            drinks.put(i, 0);
        }

        List<Pizza> pizzas = new ArrayList<Pizza>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to 301 Pizza!: ");
        String userInput = "SENTINEL";

        while (!userInput.equals("QUIT")) {
            System.out.println("What would you like to order? [Pizza, Drink, Checkout]");
            userInput = scanner.nextLine();

            // Parse user input
            if (userInput.equals("Pizza")) {
                Pizza nextPizza = getPizzasLoop();
                if (nextPizza != null) {
                    System.out.println(nextPizza); // TESTING ONLY
                    pizzas.add(nextPizza);
                }
            } else if (userInput.equals("Drink")) {
                System.out.println(drinks); // TESTING ONLY
                int[] drinkResult = getDrinksLoop(drinks);
                if (drinkResult[0] != 0) {
                    drinks.put(drinkResult[0], drinkResult[1]);
                }
            } else if (userInput.equals("Checkout")) {
                ; // GO TO CHECKOUT
            } else {
                ; // INVALID INPUT
            }

            //////////////////////////
            // scanner.close();
        }

    }

}