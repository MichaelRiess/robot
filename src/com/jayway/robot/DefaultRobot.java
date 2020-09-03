package com.jayway.robot;

public class DefaultRobot implements Robot {

    private final Room room;

    private RobotPosition position;
    private Direction direction;

    public DefaultRobot(Room room, RobotPosition position, Direction direction) {
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
    public RobotPosition getPosition() {
        return position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

}
