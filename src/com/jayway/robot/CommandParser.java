package com.jayway.robot;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.jayway.robot.Command.*;
import static java.util.Arrays.stream;

public class CommandParser {

    private static final Map<String, Command> swedishTokens = Map.of(
            "L", turnLeft, "R", turnRight, "F", moveForward);

    private static final Map<String, Command> englishTokens = Map.of(
            "V", turnLeft, "H", turnRight, "G", moveForward);

    private static final Map<String, Map<String, Command>> tokenMaps = Map.of(
            "en", swedishTokens, "se", englishTokens
    );

    public static Stream<Command> streamCommands(String language, String commandTokens) {
        if (commandTokens == null) {
            return Stream.empty();
        }
        return stream(commandTokens.split(""))
                .map(s -> parseCommand(language, s));
    }

    public static Command parseCommand(String language, String token) {
        return Optional.ofNullable(tokenMaps.get(language))
                .map(tokenMap -> tokenMap.get(token))
                .orElseThrow(() -> new IllegalArgumentException("no command found for token " + token + " in language " + language));
    }

}
