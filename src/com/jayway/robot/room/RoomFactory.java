package com.jayway.robot.room;

import com.jayway.robot.Direction;
import com.jayway.robot.Position;

/**
 * The circle room has been left out,
 * since the requirements were unclear on
 * how to construct/define it.
 */
public class RoomFactory {
    public static Room createUnboundedRoom(Position start, Direction direction) {
        return new UnboundedRoom(start, direction);
    }

    public static Room createSquareRoom(int size, Position start, Direction direction) {
        return new SquareRoom(start, direction, size);
    }

}
