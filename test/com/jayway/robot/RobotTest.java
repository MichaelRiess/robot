package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.*;
import static com.jayway.robot.Direction.*;
import static com.jayway.robot.RobotFactory.createRobot;
import static com.jayway.robot.room.RoomFactory.createSquareRoom;
import static com.jayway.robot.room.RoomFactory.createUnboundedRoom;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void itTurnsLeftWithoutMoving() {
        var robot = createRobot(createUnboundedRoom(Position.of(0, 0), facingNorth));

        var previousPosition = robot.getPosition();
        var previousDirection = robot.getDirection();

        robot.execute(turnLeft);

        assertEquals(previousDirection.turnLeft(), robot.getDirection());
        assertEquals(previousPosition, robot.getPosition());
    }

    @Test
    void itTurnsRightWithoutMoving() {
        var robot = createRobot(createUnboundedRoom(Position.of(0, 0), facingNorth));

        var previousPosition = robot.getPosition();
        var previousDirection = robot.getDirection();

        robot.execute(turnRight);

        assertEquals(previousDirection.turnRight(), robot.getDirection());
        assertEquals(previousPosition, robot.getPosition());
    }

    @Test
    void itMovesForwardWithoutTurning() {
        var start = Position.of(0, 0);
        var robot = createRobot(createUnboundedRoom(start, facingNorth));

        var previousDirection = robot.getDirection();

        robot.execute(moveForward);

        assertEquals(start.offset(0, -1), robot.getPosition());
        assertEquals(previousDirection, robot.getDirection());
    }

    @Test
    void itRunsExample2() {
        var start = Position.of(0, 0);
        var robot = createRobot(createUnboundedRoom(start, facingNorth));

        CommandParser.streamCommands("en", "RRFLFFLRF").forEach(robot::execute);

        assertEquals(start.offset(3, 1), robot.getPosition());
        assertEquals(facingEast, robot.getDirection());
    }

    @Test
    void itDoesntLeaveABoundedRoom() {
        var start = Position.of(0, 0);
        var robot = createRobot(createSquareRoom(2, start, facingSouth));

        CommandParser.streamCommands("se", "GGGVGGG").forEach(robot::execute);

        assertEquals(facingEast, robot.getDirection());
        assertEquals(start.offset(1, 1), robot.getPosition());

    }

}