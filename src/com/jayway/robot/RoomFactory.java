package com.jayway.robot;

import java.awt.*;

public class RoomFactory {
    public static Room unboundedRoom(int startX, int startY) {
        return new Room() {
            @Override
            public Point getStartPosition() {
                return new Point(startX, startY);
            }

            @Override
            public boolean contains(Point position) {
                return true;
            }
        };
    }

    public static Room squareRoom(int size, int startX, int startY) {
        return new Room() {
            @Override
            public Point getStartPosition() {
                return new Point(startX, startY);
            }

            @Override
            public boolean contains(Point position) {
                return position.x >= 0 && position.x < size &&
                        position.y >= 0 && position.y < size;
            }
        };
    }

}
