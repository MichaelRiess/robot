package com.jayway.robot;

import static com.jayway.robot.Command.streamCommands;
import static java.util.Arrays.stream;

public class RobotCLI {
    public static void main(String... args) {
        try {
            run(args);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("usage: x y [se|en] MOVEMENTS", e);
        }
    }

    public static void run(String[] args) {
        if (args == null || args.length < 4) {
            throw new IllegalArgumentException();
        }

        var x = Integer.parseInt(args[0]);
        var y = Integer.parseInt(args[1]);
        var language = args[2];
        var commands = streamCommands(language, args[3]);

        var room = RoomFactory.unboundedRoom(x, y);
        var robot = RobotEngine.run(room, commands);

        System.out.println(robot.getPosition() + " " + robot.getDirection().asLetter());
    }

}
