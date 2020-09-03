package com.jayway.robot.room;

import com.jayway.robot.Direction;
import com.jayway.robot.Position;

import java.awt.*;

import static com.jayway.robot.Direction.facingNorth;

/**
 * NOTE: due to requirements this interface uses the
 * mutable awt class {@link Point}. Since we want to use an
 * immutable data class instead, default methods were used
 * to do the conversion. We also introduced a method
 * specifying the starting direction here, to go with
 * the method specifying the start position.
 */
public interface Room {
    java.awt.Point getStartPosition();
    boolean contains(java.awt.Point position);

    default Position getRobotStartPosition() {
        return Position.of(getStartPosition());
    }

    default boolean contains(Position position) {
        return contains(new Point(position.asPoint()));
    }

    default Direction getStartDirection() {
        return facingNorth;
    }
}
