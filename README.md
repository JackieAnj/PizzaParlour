## Pair programming

### Process
We decided to conduct our pair programming online, using Discord's voice chat and screen sharing feature.
Before doing any coding, we had an initial planning meeting for almost 3 hours. 
1. The first feature we implemented using pair programming is the ability to order pizzas and drinks. 
The implementation of the order feature was planned as a team during the first team meeting, 
and a flow chart representing the process of placing an order was created (see FlowChart.png). 
The coding of this feature was completed in two sittings, with each sitting lasting roughly 1 hour. 
Pi was the driver and I (Jackie) was the navigator for both sittings.

2. The second feature we implemented as a pair was the ability for the user to call up a menu, 
or search up a specific menu item. The implementation of the menu feature was also planned as 
a team during the first team meeting. The coding of this feature was completed in one sitting, 
roughly taking an hour. I (Jackie) was the driver this time with Pi being the navigator.

3. For testing I was the driver writing most of the unit tests, while Pi was the navigator. 
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
doing so would corrupt the logic. We also decided to leave most methods package-private rather than private 
since we want to leave the option open of testing most methods. 


## How to use PizzaParlour.java 
***** WIP 