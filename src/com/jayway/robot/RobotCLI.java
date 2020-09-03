package com.jayway.robot;

import static com.jayway.robot.Command.streamCommands;
import static com.jayway.robot.Direction.facingNorth;
import static com.jayway.robot.RobotFactory.createRobot;
import static com.jayway.robot.RoomFactory.createUnboundedRoom;

public class RobotCLI {

    public static void main(String... args) {
        try {
            System.out.println(run(args));
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("parameters: startX startY [se|en] MOVEMENTS", e);
        }
    }

    public static String run(String... args) {
        if (args == null || args.length < 4) {
            throw new IllegalArgumentException();
        }

        var x = Integer.parseInt(args[0]);
        var y = Integer.parseInt(args[1]);
        var room = createUnboundedRoom(x, y, facingNorth);

        var robot = createRobot(room);

        var language = args[2];
        streamCommands(language, args[3]).forEach(robot::execute);

        return robot.getPosition() + " " + robot.getDirection().asLetter();
    }
}
