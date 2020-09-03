package com.jayway.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotApplicationTest {
    @Test
    void itRunsExample1() {
        assertEquals("1 3 N", RobotApplication.run("1", "2", "se", "HGHGGHGHG"));
    }
}