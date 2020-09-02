package com.jayway.robot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.jayway.robot.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void itWorksFromNorth() {
        assertEquals(east, north.turnRight());
        assertEquals(west, north.turnLeft());
    }

    @Test
    void itWorksFromSouth() {
        assertEquals(west, south.turnRight());
        assertEquals(east, south.turnLeft());
    }

    @Test
    void itWorksFromWest() {
        assertEquals(north, west.turnRight());
        assertEquals(south, west.turnLeft());
    }

    @Test
    void itWorksFromEast() {
        assertEquals(south, east.turnRight());
        assertEquals(north, east.turnLeft());
    }
}