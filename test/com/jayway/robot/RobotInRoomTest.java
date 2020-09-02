package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static org.junit.jupiter.api.Assertions.*;

class RobotInRoomTest {

    private final RobotInRoom robotInRoom = new RobotInRoom(new RobotPosition(0, 0));

    @Test
    void itTurnsLeftWithoutMoving() {
        var previousPosition = robotInRoom.getPosition();

        robotInRoom.execute(turnLeft);

        assertEquals(Direction.west, robotInRoom.getDirection());
        assertEquals(previousPosition, robotInRoom.getPosition());
    }

    @Test
    void itTurnsRightWithoutMoving() {
        var previousPosition = robotInRoom.getPosition();

        robotInRoom.execute(turnRight);

        assertEquals(Direction.east, robotInRoom.getDirection());
        assertEquals(previousPosition, robotInRoom.getPosition());
    }

    @Test
    void itMovesForwardWithoutTurning() {
        var previousDirection = robotInRoom.getDirection();

        robotInRoom.execute(moveForward);

        assertEquals(new RobotPosition(0, -1), robotInRoom.getPosition());
        assertEquals(previousDirection, robotInRoom.getDirection());
    }
}