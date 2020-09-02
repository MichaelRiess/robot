package com.jayway.robot;

import static com.jayway.robot.Command.streamCommands;
import static com.jayway.robot.Direction.facingNorth;

public class RobotCLI {

    public static void main(String... args) {
        try {
            run(args);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("parameters: startX startY [se|en] MOVEMENTS", e);
        }
    }

    public static void run(String[] args) {
        if (args == null || args.length < 4) {
            throw new IllegalArgumentException();
        }

        var x = Integer.parseInt(args[0]);
        var y = Integer.parseInt(args[1]);
        var room = RoomFactory.unboundedRoom(x, y);

        var robot = new Robot(room.getRobotStartPosition(), facingNorth);

        var language = args[2];

        streamCommands(language, args[3]).forEach(robot::execute);

        System.out.println(robot.getPosition() + " " + robot.getDirection().asLetter());
    }
}
