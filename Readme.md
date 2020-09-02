# The Robot Project

## General remarks

* Since no other libraries and tools than plain JDK and a testing framework should be used and it should be compiled using either Idea or Eclipse, this repository contains just the java sources and IntelliJ Idea project files.
* In a production project I would prefer to use at least Maven/Gradle.
* Redundant javadoc has been left out intentionally. The unit tests and the RobotCLI class serve as a better documentation on how to use the classes, since they are living code instead of "dead" text.
* interfaces have not been extracted for classes where they then would have only one implementing class. For example, instead of having Robot and RobotImpl, or IRobot and Robot, we just have a class Robot. Interfaces can be extracted later, if it becomes necessary to have more than one implementation.
* Most of the classes are immutable and therefore stateless, except for the Robot of course, which moves through the room. Immutable objects lead to more robust code, and the penalty of having to create new objects is very small in modern virtual machines.



