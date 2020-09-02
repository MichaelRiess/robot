package com.jayway.robot;

public class RobotInRoom {

    private RobotPosition position;
    private Direction facing = Direction.north;

    public RobotInRoom(RobotPosition position) {
        this.position = position;
    }

    public void execute(Command command) {
        switch(command) {
            case turnLeft:
                facing = facing.turnLeft();
                break;
            case turnRight:
                facing = facing.turnRight();
                break;
            case moveForward:
                position = position.inDirection(facing);
                break;
        }
    }

    public RobotPosition getPosition() {
        return position;
    }

    public Direction getDirection() {
        return facing;
    }

}
