## How to use

## Pair programming

### Process
We decided to conduct our pair programming online, using Discord's voice chat and screen sharing feature.
1. The first feature we implemented using pair programming is the ability to order pizzas and drinks. The implementation of the order feature was planned as a team during the first team meeting, and a flow chart representing the prcoess of placing an order was created. The coding of this feature was completed in two sittings, with each sitting lasting roughly 1 hour. Pi was the driver and I (Jackie) was the navigator for both sittings.
2. The second feature we implemented as a pair was the ability for the user to call up a menu, or search up a specific menu item. The implementation of the menu feature was also planned as a team during the first team meeting. The coding of this feature was completed in one sitting, roughly taking an hour. I (Jackie) was the driver this time with Pi being the navigator.
3. For testing ///TBD
### Refection
The overall pair programming process went smoothly. We did not encounter any major technical or communication problems. Due to time constraints, We decided to not switch rules during the features themselves as we felt it halted the development process. By having one driver complete one feature, they are able to work on the feature long enough to get into the groove of things. This also allowed the navigator enough time to think about any problems that could occur or improvements to the design.

We enjoyed the teamwork aspect of pair programming. We were able to discuss any questions and concerns we had while coding in real time, which reduced the time wasted waiting for responses from group members that are doing their own thing. Programming together also meant we were able to share our own ideas and apply our individual strengths to the project. There were times when one member of the team would be familiar with a certain tool or way of doing a task, and they were able to take the lead and guide the other person through that part of the program.

One thing we found to be a disadvantage or pair programming is when we are writing code that do not require any discussion. An example would be when the driver clearly knows how to implement a specific section, the navigator will simply be observing the whole time. Although situations like that does not occur often, when it does happen we feel like the observer could have used that time to work on other parts of the project.

## Design

### Design patterns
We have implemented the following design partterns in our program:
#### 1. Factory Method
We made Factories for the two types of objects that the program will need to create, which are Pizzas and Orders. Pizza is an abstract class with all the different types of pizzas as its subclass, each with their own constructor. The PizzaFactory has a method for each type of pizza that calls on the the corresponding pizza type's constructor. Similarly the OrderFactory also has a method for each type of order that calls on the corresponding order type's constructor.

Any object creation in main is done through the factories. This adds a layer of encapsulation, allowing the program to work with different implementations of Pizza and Order objects.

#### 2. Builder
We implemented the Builder design pattern in the various methods in main. The program will ask the user for information needed to complete a task one input at a time. Everytime the program receives an input, It will conduct error checking to make sure the input is valid, then prompt the user to enter the next input until either all reqiured fields are acquired or the user manually exits.

This ensures that when the program is sending the arguments to the constructors, the arguments will always be in the correct order and format.

#### 3. Adaptor
***** to be written
### Relationships between objects
In our program we aimed to have low coupling between the objects. Each object is able to be modified while still maintaining the functionality of the overall program. We acheived this by making sure there are no artificial dependencies. If there are classes that share common attributes or methods, they will be defined in the parent class. An example of this can be seen in the Pizza abstract class, and its attributes size and quantity.

We also designed our program to have high cohesion. We did so by making sure each class only has one specific task, so that the classes only contains attributes and methods that are relevent to the class' purpose.
### Formatting tools
***** to be written
