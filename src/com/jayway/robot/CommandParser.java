package com.jayway.robot;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class CommandParser {
    public static Stream<Command> streamCommands(String language, String commandTokens) {
        return stream(commandTokens.split("")).map(s -> parseCommand(language, s));
    }

    public static Command parseCommand(String language, String token) {
        switch (language) {
            case "se":
                return parseSwedishCommand(token);
            case "en":
                return parseEnglishCommand(token);
            default:
                throw new IllegalArgumentException("language not supported: " + language);
        }
    }

    public static Command parseEnglishCommand(String token) {
        switch (token) {
            case "L":
                return Command.turnLeft;
            case "R":
                return Command.turnRight;
            case "F":
                return Command.moveForward;
            default:
                throw new IllegalArgumentException("not a valid english command: " + token);
        }
    }

    public static Command parseSwedishCommand(String token) {
        switch (token) {
            case "V":
                return Command.turnLeft;
            case "H":
                return Command.turnRight;
            case "G":
                return Command.moveForward;
            default:
                throw new IllegalArgumentException("not a valid swedish command: " + token);
        }
    }
}
