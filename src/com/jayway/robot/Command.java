package com.jayway.robot;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public enum Command {
    turnLeft, turnRight, moveForward;

    public static Command from(String language, String token) {
        if (language.equals("se")) {
            switch (token) {
                case "V":
                    return turnLeft;
                case "H":
                    return turnRight;
                case "G":
                    return moveForward;
                default:
                    throw new IllegalArgumentException("not a valid swedish command: " + token);
            }
        }
        if (language.equals("en")) {
            switch (token) {
                case "L":
                    return turnLeft;
                case "R":
                    return turnRight;
                case "F":
                    return moveForward;
                default:
                    throw new IllegalArgumentException("not a valid english command: " + token);
            }
        }
        throw new IllegalArgumentException("language not supported: " + language);
    }

    public static Stream<Command> streamCommands(String language, String commandTokens) {
        return stream(commandTokens.split("")).map(s -> Command.from(language, s));
    }

}