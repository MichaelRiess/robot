package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static com.jayway.robot.Direction.facingEast;
import static com.jayway.robot.Direction.facingWest;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private final Robot robot = new Robot(new RobotPosition(0, 0));

    @Test
    void itTurnsLeftWithoutMoving() {
        var previousPosition = robot.getPosition();

        robot.execute(turnLeft);

        assertEquals(facingWest, robot.getDirection());
        assertEquals(previousPosition, robot.getPosition());
    }

    @Test
    void itTurnsRightWithoutMoving() {
        var previousPosition = robot.getPosition();

        robot.execute(turnRight);

        assertEquals(facingEast, robot.getDirection());
        assertEquals(previousPosition, robot.getPosition());
    }

    @Test
    void itMovesForwardWithoutTurning() {
        var previousDirection = robot.getDirection();

        robot.execute(moveForward);

        assertEquals(new RobotPosition(0, -1), robot.getPosition());
        assertEquals(previousDirection, robot.getDirection());
    }
}