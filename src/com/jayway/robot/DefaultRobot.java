package com.jayway.robot;

import com.jayway.robot.room.Room;

public class DefaultRobot implements Robot {

    private final Room room;

    private Position position;
    private Direction direction;

    public DefaultRobot(Room room, Position position, Direction direction) {
        this.room = room;
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void execute(Command command) {
        switch(command) {
            case turnLeft:
                turnLeft();
                break;
            case turnRight:
                turnRight();
                break;
            case moveForward:
                moveForward();
                break;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void moveForward() {
        var newPosition = position.moveForward(direction);
        if (!room.contains(newPosition)) {
            // the requirements do not specify what should happen when the robot encounters a "wall".
            // the natural thing seems to be to just not move forward.
            return;
        }

        position = newPosition;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

}
