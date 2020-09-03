package com.jayway.robot.room;

import com.jayway.robot.Direction;
import com.jayway.robot.Position;

import java.awt.*;

class SquareRoom extends UnboundedRoom {
    private final int size;

    SquareRoom(Position start, Direction direction, int size) {
        super(start, direction);
        this.size = size;
    }

    @Override
    public boolean contains(Point position) {
        return position.x >= 0 && position.x < size &&
                position.y >= 0 && position.y < size;
    }
}
