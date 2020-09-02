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
        var room = unboundedRoom(1, 2);
        var robot = new Robot(room.getRobotStartPosition(), facingNorth);

        streamCommands("se", "HGHGGHGHG").forEach(robot::execute);

        assertEquals(new RobotPosition(1, 3), robot.getPosition());
        assertEquals(facingNorth, robot.getDirection());
    }

    @Test
    void itRunsExample2() {
        var room = unboundedRoom(0, 0);
        var robot = new Robot(room.getRobotStartPosition(), facingNorth);

        streamCommands("en", "RRFLFFLRF").forEach(robot::execute);

        assertEquals(new RobotPosition(3, 1), robot.getPosition());
        assertEquals(facingEast, robot.getDirection());
    }
}