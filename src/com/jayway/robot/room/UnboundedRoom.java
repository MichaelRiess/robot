package com.jayway.robot.room;

import com.jayway.robot.Direction;

import java.awt.*;

class UnboundedRoom implements Room {
    private final int startX;
    private final int startY;
    private final Direction direction;

    public UnboundedRoom(int startX, int startY, Direction direction) {
        this.startX = startX;
        this.startY = startY;
        this.direction = direction;
    }

    @Override
    public Point getStartPosition() {
        return new Point(startX, startY);
    }

    @Override
    public Direction getStartDirection() {
        return direction;
    }

    @Override
    public boolean contains(Point position) {
        return true;
    }
}
