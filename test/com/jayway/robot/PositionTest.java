package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void itShouldMoveInAllDirections() {
        var pos = Position.of(0, 0);
        assertEquals(Position.of(0, -1), pos.moveForward(facingNorth));
        assertEquals(Position.of(0, 1), pos.moveForward(facingSouth));
        assertEquals(Position.of(1, 0), pos.moveForward(facingEast));
        assertEquals(Position.of(-1, 0), pos.moveForward(facingWest));
    }

}