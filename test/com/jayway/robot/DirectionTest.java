package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void itWorksFromNorth() {
        assertEquals(facingEast, facingNorth.turnRight());
        assertEquals(facingWest, facingNorth.turnLeft());
    }

    @Test
    void itWorksFromSouth() {
        assertEquals(facingWest, facingSouth.turnRight());
        assertEquals(facingEast, facingSouth.turnLeft());
    }

    @Test
    void itWorksFromWest() {
        assertEquals(facingNorth, facingWest.turnRight());
        assertEquals(facingSouth, facingWest.turnLeft());
    }

    @Test
    void itWorksFromEast() {
        assertEquals(facingSouth, facingEast.turnRight());
        assertEquals(facingNorth, facingEast.turnLeft());
    }
}