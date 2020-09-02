package com.jayway.robot;

public class Robot {

    public static Robot from(Room room) {
        // due to requirements the room contains separate concerns ... we separate them here at least.
        return new Robot(room, room.getRobotStartPosition(), room.getStartDirection());
    }

    private final Room room;

    private RobotPosition position;
    private Direction direction;

    private Robot(Room room, RobotPosition position, Direction direction) {
        this.room = room;
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
                var newPosition = position.moveForward(direction);
                if (room.contains(newPosition)) {
                    position = newPosition;
                }
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
