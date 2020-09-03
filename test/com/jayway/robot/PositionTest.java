package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void deltaWorks() {
        var pos = Position.of(0, 0);

        assertEquals(Position.of(0, -1), pos.shift(0, -1));
        assertEquals(Position.of(0, 1), pos.shift(0, 1));
        assertEquals(Position.of(-1, 0), pos.shift(-1, 0));
        assertEquals(Position.of(1, 0), pos.shift(1, 0));
        assertEquals(Position.of(1, 1), pos.shift(1, 1));
        assertEquals(Position.of(-1, -1), pos.shift(-1, -1));
    }

    @Test
    void itShouldMoveInAllDirections() {
        var pos = Position.of(0, 0);

        assertEquals(pos.shift(0, -1), pos.moveForward(facingNorth));
        assertEquals(pos.shift(0, 1), pos.moveForward(facingSouth));

        assertEquals(pos.shift(-1, 0), pos.moveForward(facingWest));
        assertEquals(pos.shift(1, 0), pos.moveForward(facingEast));
    }

}