package com.jayway.robot;

import java.awt.*;

/**
 * The circle room has been left out,
 * since the requirements were unclear on
 * how to construct/define it.
 */
public class RoomFactory {
    public static Room unboundedRoom(int startX, int startY, Direction direction) {
        return new Room() {
            @Override
            public Point getStartPosition() {
                return new Point(startX, startY);
            }

            @Override
            public Direction startingDirection() {
                return direction;
            }

            @Override
            public boolean contains(Point position) {
                return true;
            }
        };
    }

    public static Room squareRoom(int size, int startX, int startY, Direction direction) {
        return new Room() {
            @Override
            public Point getStartPosition() {
                return new Point(startX, startY);
            }
            @Override
            public Direction startingDirection() {
                return direction;
            }

            @Override
            public boolean contains(Point position) {
                return position.x >= 0 && position.x < size &&
                        position.y >= 0 && position.y < size;
            }
        };
    }

}
