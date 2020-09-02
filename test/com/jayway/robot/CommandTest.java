package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void itParsesSwedishTokens() {
        assertEquals(turnLeft, Command.from("se", "V"));
        assertEquals(turnRight, Command.from("se", "H"));
        assertEquals(moveForward, Command.from("se", "G"));
    }

    @Test
    void itParsesEnglishTokens() {
        assertEquals(turnLeft, Command.from("en", "L"));
        assertEquals(turnRight, Command.from("en", "R"));
        assertEquals(moveForward, Command.from("en", "F"));
    }
}