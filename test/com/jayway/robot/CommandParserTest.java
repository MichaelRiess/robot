package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static com.jayway.robot.CommandParser.parseCommand;
import static com.jayway.robot.CommandParser.streamCommands;
import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    void itStreamsNull() {
        assertNotNull(streamCommands("se", null));
    }

    @Test
    void itRejectsInvalidLanguage() {
        assertThrows(IllegalArgumentException.class, () -> parseCommand(null, "V"));
        assertThrows(IllegalArgumentException.class, () -> parseCommand("de", "V"));
    }

    @Test
    void itRejectsMissingToken() {
        assertThrows(IllegalArgumentException.class, () -> parseCommand("se", null));
    }

    @Test
    void itParsesSwedishTokens() {
        assertEquals(turnLeft, parseCommand("se", "V"));
        assertEquals(turnRight, parseCommand("se", "H"));
        assertEquals(moveForward, parseCommand("se", "G"));
    }

    @Test
    void itParsesEnglishTokens() {
        assertEquals(turnLeft, parseCommand("en", "L"));
        assertEquals(turnRight, parseCommand("en", "R"));
        assertEquals(moveForward, parseCommand("en", "F"));
    }
}