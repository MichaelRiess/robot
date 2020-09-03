package com.jayway.robot;

public class RobotFactory {
    public static Robot createRobot(Room room) {
        // due to requirements the room contains separate concerns ... we separate them here at least.
        return new DefaultRobot(room, room.getRobotStartPosition(), room.getStartDirection());
    }
}
