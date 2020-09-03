package com.jayway.robot.room;

import com.jayway.robot.Direction;

import java.awt.*;

class SquareRoom implements Room {
    private final int startX;
    private final int startY;
    private final Direction direction;
    private final int size;

    public SquareRoom(int startX, int startY, Direction direction, int size) {
        this.startX = startX;
        this.startY = startY;
        this.direction = direction;
        this.size = size;
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
        return position.x >= 0 && position.x < size &&
                position.y >= 0 && position.y < size;
    }
}
