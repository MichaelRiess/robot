package com.jayway.robot;

import java.util.stream.Stream;

public class RobotEngine {
    public static Robot run(int x, int y, Stream<Command> commands) {
        var robot = new Robot(new RobotPosition(x, y));

        commands.forEach(robot::execute);

        return robot;
    }

}
