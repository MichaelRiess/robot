package com.jayway.robot;

import static com.jayway.robot.Direction.facingNorth;

public class Robot {

    private RobotPosition position;
    private Direction direction = facingNorth;

    public Robot(RobotPosition position) {
        this.position = position;
    }

    public void execute(Command command) {
        switch(command) {
            case turnLeft:
                direction = direction.turnLeft();
                break;
            case turnRight:
                direction = direction.turnRight();
                break;
            case moveForward:
                position = position.towards(direction);
                break;
        }
    }

    public RobotPosition getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

}
