## Assumptions

NOTE: Since many parts of the specification could be interpreted in several ways, we are going to write
our assumptions/interpretations of the specs in case we diverged from what the professors/TAs envisioned. 

(1) We assumed that adding new types of pizza meant Custom pizzas should be allowed and the Pizza Parlour
could create new subclasses of Pizza if it noted certain Custom choices were popular.

(2) We assumed that only Custom pizzas could have their toppings changed since otherwise customers could 
hack their way into always getting discounts for pizzas. Since pre-made pizzas offer cheaper prices 
lower than usual for the provided toppings (or there would be no point in them), 
users could just remove all toppings and then add exactly what they want for a cheaper price.

(3) For modifying an order, we have the ability to add/change/remove pizzas, add/change(quantity)/remove drinks
and change the address. We did not give the option to change delivery type because the specs seemed to focus on 
changing the food of an order although we added address in case the user made a small typo earlier. 

(4) Commands are case sensitive since we focused on the required functionality and program design over
complex user input parsing. 

## Pair programming

### Process
We decided to conduct our pair programming online, using Discord's voice chat and screen sharing feature.
Before doing any coding, we had an initial planning meeting for almost 3 hours. 
1. The first feature we implemented using pair programming is the ability to order pizzas and drinks. 
The implementation of the order feature was planned as a team during the first team meeting, 
and a flow chart representing the process of placing an order was created (see FlowChart.png). 
The coding of this feature was completed in two sittings, with each sitting lasting roughly 1 hour. 
Pi was the driver and Jackie was the navigator for both sittings.

2. The second feature we implemented as a pair was the ability for the user to call up a menu, 
or search up a specific menu item. The implementation of the menu feature was also planned as 
a team during the first team meeting. The coding of this feature was completed in one sitting, 
roughly taking an hour. Jackie was the driver this time with Pi being the navigator.

3. For testing Jackie was the driver writing most of the unit tests, while Pi was the navigator. 
Both of us contributed in coming up with the various test cases. 
Pi also had a role of building the features of the program in a way that would allow for easy testing.

### Reflection
The overall pair programming process went smoothly. 
We did not encounter any major technical or communication problems. 
Due to severe time constraints, We decided to not switch roles during the features themselves as we felt it halted the 
development process. By having one driver complete one feature, they are able to work on the feature long enough 
to "get into the groove of things". This also allowed the navigator enough time to think about any 
problems that could occur or improvements to the design.

We enjoyed the teamwork aspect of pair programming. 
We were able to discuss any questions and concerns we had while coding in real time, 
which reduced the time wasted waiting for responses from group members that are doing their own thing. 
Programming together also meant we were able to share our own ideas and apply our individual strengths to the project. 
There were times when one member of the team would be familiar with a certain tool or way of doing a task, 
and they were able to take the lead and guide the other person through that part of the program.

One thing we found to be a disadvantage or pair programming is when we are writing code 
that do not require any discussion. An example would be when the driver clearly knows how to implement 
a specific section, the navigator will simply be observing the whole time. Although situations like 
this do not occur often, when it does happen we feel like the observer could have used that time 
to work on other parts of the project.


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
