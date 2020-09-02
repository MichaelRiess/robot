package com.jayway.robot;

import java.util.List;

public enum Direction {
    north, south, west, east;

    private static final List<Direction> directions = List.of(north, east, south, west);

    public Direction turnLeft() {
        var pos = directions.indexOf(this) - 1;
        return directions.get(pos < 0 ? directions.size() - 1 : pos);
    }

    public Direction turnRight() {
        var pos = directions.indexOf(this) + 1;
        return directions.get(pos == directions.size() ? 0 : pos);
    }
}
