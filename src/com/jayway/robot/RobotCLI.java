package com.jayway.robot;

import java.util.stream.Stream;

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

            RobotInRoom robot = run(x, y, commands);

            System.out.println(robot.getPosition() + " " + robot.getDirection().asLetter());
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("usage: x y [se|en] MOVEMENTS", e);
        }
    }

    public static RobotInRoom run(int x, int y, Stream<Command> commands) {
        var robot = new RobotInRoom(new RobotPosition(x, y));

        commands.forEach(robot::execute);

        return robot;
    }

    public static Stream<Command> streamCommands(String language, String commandTokens) {
        return stream(commandTokens.split(""))
                .map(s -> Command.from(language, s));
    }
}
