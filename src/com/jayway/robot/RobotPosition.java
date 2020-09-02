package com.jayway.robot;

import java.util.Objects;

public class RobotPosition {

    private final int x;
    private final int y;

    public RobotPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public RobotPosition towards(Direction direction) {
        switch (direction) {
            case facingNorth:
                return new RobotPosition(x, y - 1);
            case facingSouth:
                return new RobotPosition(x, y + 1);
            case facingWest:
                return new RobotPosition(x - 1, y);
            case facingEast:
                return new RobotPosition(x + 1, y);
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RobotPosition)) {
            return false;
        }
        RobotPosition that = (RobotPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return x + " " + y;
    }
}
