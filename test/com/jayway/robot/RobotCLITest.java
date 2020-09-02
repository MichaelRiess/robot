package com.jayway.robot;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.jayway.robot.Direction.east;
import static com.jayway.robot.Direction.north;
import static org.junit.jupiter.api.Assertions.*;

class RobotCLITest {

    @Test
    void itRunsExample1() {
        var commands = RobotCLI.streamCommands("se", "HGHGGHGHG");

        var robot = RobotCLI.run(1, 2, commands);

        assertEquals(new RobotPosition(1, 3), robot.getPosition());
        assertEquals(north, robot.getDirection());
    }
    @Test
    void itRunsExample2() {
        var commands = RobotCLI.streamCommands("en", "RRFLFFLRF");

        var robot = RobotCLI.run(0, 0, commands);
        assertEquals(new RobotPosition(3, 1), robot.getPosition());
        assertEquals(east, robot.getDirection());
    }
}