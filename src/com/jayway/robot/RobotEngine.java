package com.jayway.robot;

import java.util.stream.Stream;

public class RobotEngine {
    public static Robot run(Room room, Stream<Command> commands) {
        var robot = new Robot(room.getRobotStartPosition());

        commands.forEach(robot::execute);

        return robot;
    }

}
