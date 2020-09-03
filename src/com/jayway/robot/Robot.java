package com.jayway.robot;

public interface Robot {
    void execute(Command command);

    Position getPosition();

    Direction getDirection();
}
