package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotCLITest {
    @Test
    void itRunsExample1() {
        assertEquals("1 3 N", RobotCLI.run("1", "2", "se", "HGHGGHGHG"));
    }
}