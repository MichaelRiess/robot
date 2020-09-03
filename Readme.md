# The Robot Project

## General remarks

* As requested, this repo contains plain Java code and Idea project files. In a production project I would prefer to use Maven/Gradle to define the structure.
* Redundant Javadoc has been left out intentionally. The unit tests and the RobotCLI class serve as a better documentation on how to use the classes, since they are living code instead of "dead" text.
* Interfaces have NOT been extracted for classes where they then would have only one implementing class. For example, instead of having Robot and RobotImpl, or IRobot and Robot, we just have a class Robot. Interfaces can be extracted later, if it becomes necessary to have more than one implementation.
* Most of the classes are immutable and therefore stateless, except for the Robot of course, which moves through the room. Immutable objects lead to more robust code, and the penalty of having to create new objects is very small in modern virtual machines.

### Unclear Requirements

The requirements are a bit vague. In an actual project I would reach out to the customer and/or product owner and ask for clarification. Given that this was just a small programming assignment, I tried to do my best with the requirements given, and spare the clarifications for the ensuing interview.

#### What type of API should I provide?

* The examples hint towards a CLI (command line interface), given that a String of commands is the input, and another String is the output. However, as I discuss in a following item, the requirements define no such strings/inputs/syntax for other inputs like the language configuration or the rooms themselves.
* Therefore I decided to provide a rudimentary CLI which works for running command strings as specified, but with "unbounded" rooms which just have a starting position. 
* Clients can run examples with more complex rooms by calling the Robot class directly, as shown in the unit tests, with their own Room implementations.
* The CLI contains only a minimum of error handling. For a production level CLI I would use something like Spring Boot CLI, which provides all the parsing and client feedback out of the box. 

#### The Room interface is messy

* Interfaces should be as small as possible and not mix different concerns. Even though the Room interface is very small, it mixes two concerns: The robot start position, and the definition of the room itself. Those should be separated into different interfaces.
* The java.awt.Point class is a blunder in the JDK and should not be used in modern code. For a coordinate tuple we would rather want to use an immutable data class without any relation to a specific UI framework or technology stack.

Since it is part of the requirements, the code uses the Room interface as defined. I added some default methods to improve the usability without the need for potential clients to implement them.

#### How Can We Specify Rooms?

* The example robot movements (example 1 and 2) specify special rooms (square and circular), but no interface is specified for how to submit them to the robot. Of course the contains() method of the room interface is sufficient for defining a room. The job of doing so (e.g. define a circular room) is outside the scope of this assignment.

#### What Happens at Room Boundaries?

* In both example 1 and 2 the robot never tries to step out of the room. The requirements say nothing about what should happen in that event. In this implementation the robot will simply ignore the forward command and do nothing when the movement would result in it occupying coordinates which are not contained in the Room.
