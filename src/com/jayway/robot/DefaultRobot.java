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
                direction = direction.turnLeft();
                break;
            case turnRight:
                direction = direction.turnRight();
                break;
            case moveForward:
                var newPosition = position.moveForward(direction);
                // the requirements do not specify what should happen when the robot encounters a "wall".
                // the natural thing seems to be to just not move forward.
                if (room.contains(newPosition)) {
                    position = newPosition;
                }
                break;
        }
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
