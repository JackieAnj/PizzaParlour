## Introduction 
This is a pair programmed Java application that was built using test driven development, implementing various design patterns.
It was done for an intro to software engineering course at the University of Toronto

## How to use PizzaParlour App 
### As a User (PizzaParlour.java)
Run PizzaParlour.main()

Select one of the provided options by entering 1, 2, 3, 4, 5, or 6.
Note that most of the app provides instructions on what to do at each step which usually involves entering 
either a number for an option (such as "2") or the option name itself (such as "Cancel"). Invalid commands
will often be met by a re-prompting. 

- (1) Create an Order: This is where you can make orders in a loop of ordering a pizza, a drink, or checking out 
by typing "Checkout". You can also cancel an order anytime by typing "Cancel". When ordering a Pizza or Drink,
simply follow the prompts and provide keyboard input as asked for. 

- (2) Update an Order: This is where you can update an order by entering the order number of the order to change
which will bring you to an interface for changing pizzas, drinks, or your address. As before, follow the prompts. 

- (3) Delete an Order: This is where you can delete an order by simply entering its order number.

- (4) Submit an Order: This is where you can submit an order by simply entering its order number. Look at 
"Result.txt" (same level as the src directory) to see the result of submitting a Uber or Foodora order (JSON or csv).

- (5) View Menu: This will bring you to an interface for viewing the menu where as given by commands,
you can view the full menu, a section of the menu, or a single menu item. Entering a valid command will retrieve 
prices for toppings and drinks. For pizzas, you get prices at different sizes and pre-set toppings for different
types of pizzas.  

- (6) Quit App: This will exit the app completely. Use this when you are done making orders. 

### As the Parlour (Menu.txt) 
Go to Menu.txt
- Add Item: Under appropriate heading (PIZZAS, etc.), put a line of the form 
ITEM NAME_ITEM INFO where for TOPPINGS and DRINKS: "ITEM NAME" is the name of the menu item, 
"_" is the separator, and "ITEM INFO" is a price such as $1.99. PIZZAS have a slightly more complicated format
for "ITEM INFO" where toppints are comma separated in brackets followed by small, medium, and large pricings.
See Menu.txt for examples.
- Modify Item: Prices are the focus of change so just change a price by edtiting the "ITEM INFO" on the right of 
the underscore separator. 
- Delete Item: Simply remove the line. 


## Program Design

### Design Patterns
We have implemented the following design patterns in our program:

#### 1. Factory Method
We made Factories for the two types of objects that the program will need to create, 
which are Pizzas and Orders. Pizza is an abstract class with all the different types of pizzas as its subclass, 
each with their own constructor. The PizzaFactory has a method for each type of pizza and calls on the 
corresponding pizza type's constructor. Similarly the OrderFactory also has a method for each type of 
order and calls on the corresponding order type's constructor.

We chose Factory so object creation for pizzas and orders in PizzaParlour is done through the factories. 
This helps prevent unnecessary dependencies since PizzaParlour lets a factory get its important objects for it.

#### 2. Builder
We implemented the Builder design pattern in various methods in PizzaParlour. 
The program will ask the user for information needed to complete a task one input at a time. 
Everytime the program receives an input, It will conduct error checking to make sure the input is valid, 
then prompt the user to enter the next input until either all required fields are acquired or the user manually exits.

We chose Builder because this ensures that when the program is sending the arguments to the constructors, 
the arguments will always be in the correct order and format.

#### 3. Adapter (*)
We use the idea of the Adapter design pattern (not actual adapter methods) when deciding the attributes of order. 
We wanted orders to be able to be displayed in JSON or CSV format without having to do any complex work. 
Reading the requirements, we chose attributes so that orders can be displayed in any format rather than needing
extra logic for a specific format (like a adapter that can be used for any device). 

### Relationships between objects
In our program we aimed to have low coupling and high cohesion between the objects. 

Each object is able to be modified while still maintaining the functionality of the overall program. 
We achieved this by making sure there are no unneeded dependencies (by using Factories for instance). 
Also, if there are classes that share common attributes or methods, that data will be defined in the parent class. 
An example of this can be seen in the Pizza abstract class, and its attributes size and quantity.
This helps us make a Pizza interface so we can use a Pizza rather than depend on a concrete implementation. 

We also designed our program to have high cohesion. We did so by making sure each class only has one specific task, 
so that the classes only contains attributes and methods that are relevant to the class' purpose. It is also clear
that all classes serve to the single purpose of having a functioning Pizza Parlour App. 

### Function Design 
Originally, we had mostly giant functions that took no arguments and gathered its input from user input 
through a Scanner using keyboard input. After starting to write tests, we realized how impractical this was 
so we used Test Driven Development as inspiration. 

We refactored functions so that they were easier to test as units. This included 
sending a Scanner as an argument to functions for user input (so we could use keyboard input or predefined 
strings in testing). There was also a focus on having many reusable helper functions as smaller tasks that 
allowed the larger tasks of the program to be accomplished using subroutines. 


## Code Craftsmanship

### Tools for Style
Since we both use the IDE IntelliJ and have experience with its code analysis feature, we decided to use this as our
tool for checking coding style. This tool is very nice to use since it often suggests hints that can be automatically 
implemented (such as IntelliJ converting a normal for loop to a for-each loop).

We still used our own judgement since there were a few cases where we thought it made sense to ignore IntelliJ's 
warnings. One example if when IntelliJ wanted to convert a series of if-else statements into switch-case where
doing so would corrupt the logic. 
