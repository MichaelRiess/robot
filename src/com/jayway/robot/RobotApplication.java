package com.jayway.robot;

import static com.jayway.robot.CommandParser.streamCommands;
import static com.jayway.robot.Direction.facingNorth;
import static com.jayway.robot.RobotFactory.createRobot;
import static com.jayway.robot.room.RoomFactory.createUnboundedRoom;
import static java.lang.Integer.parseInt;

public class RobotApplication {

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

        var start = Position.of(parseInt(args[0]), parseInt(args[1]));
        var room = createUnboundedRoom(start, facingNorth);
        var robot = createRobot(room);

        var language = args[2];
        streamCommands(language, args[3]).forEach(robot::execute);

        return robot.getPosition() + " " + robot.getDirection().asLetter();
    }
}
