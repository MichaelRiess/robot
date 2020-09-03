package com.jayway.robot;

public interface Robot {
    void execute(Command command);

    RobotPosition getPosition();

    Direction getDirection();
}
