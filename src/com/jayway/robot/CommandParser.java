package com.jayway.robot;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class CommandParser {
    public static Stream<Command> streamCommands(String language, String commandTokens) {
        if (commandTokens == null) {
            return Stream.empty();
        }
        return stream(commandTokens.split("")).map(s -> parseCommand(language, s));
    }

    public static Command parseCommand(String language, String token) {
        if (language == null) {
            throw new IllegalArgumentException();
        }
        if (token == null) {
            throw new IllegalArgumentException();
        }

        switch (language) {
            case "se":
                return parseSwedishCommand(token);
            case "en":
                return parseEnglishCommand(token);
            default:
                throw new IllegalArgumentException("language not supported: " + language);
        }
    }

    private static Command parseEnglishCommand(String token) {
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

    private static Command parseSwedishCommand(String token) {
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
