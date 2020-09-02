package com.jayway.robot;

import java.awt.*;

import static com.jayway.robot.Direction.facingNorth;

/**
 * NOTE: due to requirements this interface uses the
 * mutable class {@link Point}. Since we want to use an
 * immutable data class instead, default methods were used
 * to do the conversion. We also introduced a method
 * specifying the starting direction here, to go with
 * the method specifying the start position.
 */
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

    default Direction getStartDirection() {
        return facingNorth;
    }
}
