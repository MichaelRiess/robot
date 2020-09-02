package com.jayway.robot;

import java.awt.*;

public class RoomFactory {
    public static Room unbounded(int startX, int startY) {
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
}
