package com.jayway.robot;

import java.util.stream.Stream;

import static com.jayway.robot.Command.streamCommands;
import static java.util.Arrays.stream;

public class RobotCLI {
    public static void main(String... args) {
        try {
            if (args == null || args.length < 4) {
                throw new IllegalArgumentException();
            }

            var x = Integer.parseInt(args[0]);
            var y = Integer.parseInt(args[1]);
            var language = args[2];
            var commands = streamCommands(language, args[3]);

            var robot = RobotEngine.run(x, y, commands);

            System.out.println(robot.getPosition() + " " + robot.getDirection().asLetter());
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("usage: x y [se|en] MOVEMENTS", e);
        }
    }

}
