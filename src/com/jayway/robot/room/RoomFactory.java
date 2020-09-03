package com.jayway.robot.room;

import com.jayway.robot.Direction;

/**
 * The circle room has been left out,
 * since the requirements were unclear on
 * how to construct/define it.
 */
public class RoomFactory {
    public static Room createUnboundedRoom(int startX, int startY, Direction direction) {
        return new UnboundedRoom(startX, startY, direction);
    }

    public static Room createSquareRoom(int size, int startX, int startY, Direction direction) {
        return new SquareRoom(startX, startY, direction, size);
    }

}
