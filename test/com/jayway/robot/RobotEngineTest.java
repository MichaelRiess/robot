package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static com.jayway.robot.Command.streamCommands;
import static com.jayway.robot.Direction.facingEast;
import static com.jayway.robot.Direction.facingNorth;
import static com.jayway.robot.RoomFactory.unboundedRoom;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotEngineTest {

    @Test
    void itRunsExample1() {
        var commands = streamCommands("se", "HGHGGHGHG");

        var robot = RobotEngine.run(unboundedRoom(1, 2), commands);

        assertEquals(new RobotPosition(1, 3), robot.getPosition());
        assertEquals(facingNorth, robot.getDirection());
    }

    @Test
    void itRunsExample2() {
        var commands = streamCommands("en", "RRFLFFLRF");

        var robot = RobotEngine.run(unboundedRoom(0, 0), commands);

        assertEquals(new RobotPosition(3, 1), robot.getPosition());
        assertEquals(facingEast, robot.getDirection());
    }
}