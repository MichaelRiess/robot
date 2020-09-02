package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static com.jayway.robot.Direction.*;
import static com.jayway.robot.RoomFactory.unboundedRoom;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private final Robot robot = Robot.from(unboundedRoom(0, 0), facingNorth);

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

    @Test
    void itRunsExample1() {
        var room = unboundedRoom(1, 2);
        var robot = Robot.from(room, facingNorth);

        streamCommands("se", "HGHGGHGHG").forEach(robot::execute);

        assertEquals(new RobotPosition(1, 3), robot.getPosition());
        assertEquals(facingNorth, robot.getDirection());
    }

    @Test
    void itRunsExample2() {
        var room = unboundedRoom(0, 0);
        var robot = Robot.from(room, facingNorth);

        streamCommands("en", "RRFLFFLRF").forEach(robot::execute);

        assertEquals(new RobotPosition(3, 1), robot.getPosition());
        assertEquals(facingEast, robot.getDirection());
    }

}