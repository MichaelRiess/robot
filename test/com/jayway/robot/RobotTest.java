package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static com.jayway.robot.Direction.*;
import static com.jayway.robot.RoomFactory.squareRoom;
import static com.jayway.robot.RoomFactory.unboundedRoom;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void itTurnsLeftWithoutMoving() {
        var robot = Robot.from(unboundedRoom(0, 0, facingNorth));

        var previousPosition = robot.getPosition();
        var previousDirection = robot.getDirection();

        robot.execute(turnLeft);

        assertEquals(previousDirection.turnLeft(), robot.getDirection());
        assertEquals(previousPosition, robot.getPosition());
    }

    @Test
    void itTurnsRightWithoutMoving() {
        var robot = Robot.from(unboundedRoom(0, 0, facingNorth));

        var previousPosition = robot.getPosition();
        var previousDirection = robot.getDirection();

        robot.execute(turnRight);

        assertEquals(previousDirection.turnRight(), robot.getDirection());
        assertEquals(previousPosition, robot.getPosition());
    }

    @Test
    void itMovesForwardWithoutTurning() {
        var robot = Robot.from(unboundedRoom(0, 0, facingNorth));

        var previousDirection = robot.getDirection();

        robot.execute(moveForward);

        assertEquals(new RobotPosition(0, -1), robot.getPosition());
        assertEquals(previousDirection, robot.getDirection());
    }

    @Test
    void itRunsExample1() {
        var robot = Robot.from(unboundedRoom(1, 2, facingNorth));

        streamCommands("se", "HGHGGHGHG").forEach(robot::execute);

        assertEquals(new RobotPosition(1, 3), robot.getPosition());
        assertEquals(facingNorth, robot.getDirection());
    }

    @Test
    void itRunsExample2() {
        var robot = Robot.from(unboundedRoom(0, 0, facingNorth));

        streamCommands("en", "RRFLFFLRF").forEach(robot::execute);

        assertEquals(new RobotPosition(3, 1), robot.getPosition());
        assertEquals(facingEast, robot.getDirection());
    }

    @Test
    void itDoesntLeaveABoundedRoom() {
        var robot = Robot.from(squareRoom(2, 0, 0, facingSouth));

        streamCommands("se", "GGGVGGG").forEach(robot::execute);

        assertEquals(facingEast, robot.getDirection());
        assertEquals(new RobotPosition(1, 1), robot.getPosition());

    }

}