package com.jayway.robot;

import java.awt.*;

import static com.jayway.robot.Direction.facingNorth;

public interface Room {
    java.awt.Point getStartPosition();
    boolean contains(java.awt.Point position);

    default RobotPosition getRobotStartPosition() {
        var startPosition = getStartPosition();
        return new RobotPosition(startPosition.x, startPosition.y);
    }

    default boolean contains(RobotPosition position) {
        return contains(new Point(position.asPoint()));
    }

    default Direction startingDirection() {
        return facingNorth;
    }
}
