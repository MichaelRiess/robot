package com.jayway.robot.room;

import com.jayway.robot.Direction;
import com.jayway.robot.Position;

import java.awt.*;

class UnboundedRoom implements Room {
    private final Position start;
    private final Direction direction;

    public UnboundedRoom(Position start, Direction direction) {
        this.start = start;
        this.direction = direction;
    }

    @Override
    public final Point getStartPosition() {
        return start.asPoint();
    }

    @Override
    public final Direction getStartDirection() {
        return direction;
    }

    @Override
    public boolean contains(Point position) {
        return true;
    }
}
