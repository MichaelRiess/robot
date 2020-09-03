package com.jayway.robot;

import java.awt.*;
import java.util.Objects;

public class Position {


    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public static Position of(Point point) {
        return new Position(point.x, point.y);
    }

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position shift(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    /**
     * This encapsulates the translation from direction/orientation
     * of the robot to the movement on the grid.
     */
    public Position moveForward(Direction direction) {
        switch (direction) {
            case facingNorth:
                return shift(0, -1);
            case facingSouth:
                return shift(0, 1);
            case facingWest:
                return shift(-1, 0);
            case facingEast:
                return shift(1, 0);
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        Position that = (Position) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return x + " " + y;
    }

    public Point asPoint() {
        return new Point(x, y);
    }
}
