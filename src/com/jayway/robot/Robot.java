package com.jayway.robot;

public class Robot {

    public static Robot from(Room room, Direction direction) {
        return new Robot(room.getRobotStartPosition(), direction);
    }

    private RobotPosition position;
    private Direction direction;

    private Robot(RobotPosition position, Direction direction) {
        this.position = position;
        this.direction = direction;
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
