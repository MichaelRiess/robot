package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class RobotPositionTest {

    @Test
    void itShouldMoveInAllDirections() {
        var pos = new RobotPosition(0, 0);
        assertEquals(new RobotPosition(0, -1), pos.moveForward(facingNorth));
        assertEquals(new RobotPosition(0, 1), pos.moveForward(facingSouth));
        assertEquals(new RobotPosition(1, 0), pos.moveForward(facingEast));
        assertEquals(new RobotPosition(-1, 0), pos.moveForward(facingWest));
    }

}