package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    void itParsesSwedishTokens() {
        assertEquals(turnLeft, CommandParser.parseCommand("se", "V"));
        assertEquals(turnRight, CommandParser.parseCommand("se", "H"));
        assertEquals(moveForward, CommandParser.parseCommand("se", "G"));
    }

    @Test
    void itParsesEnglishTokens() {
        assertEquals(turnLeft, CommandParser.parseCommand("en", "L"));
        assertEquals(turnRight, CommandParser.parseCommand("en", "R"));
        assertEquals(moveForward, CommandParser.parseCommand("en", "F"));
    }
}