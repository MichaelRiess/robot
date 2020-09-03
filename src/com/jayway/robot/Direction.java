package com.jayway.robot;

import java.util.List;

import static java.util.Arrays.asList;

public enum Direction {
    facingNorth("N"), facingEast("Ö"), facingSouth("S"), facingWest("V");

    public static final List<Direction> directions = asList(values());

    private final String letter;

    Direction(String letter) {
        this.letter = letter;
    }

    public Direction turnLeft() {
        return get(directions.indexOf(this) - 1);
    }

    public Direction turnRight() {
        return get(directions.indexOf(this) + 1);
    }

    private Direction get(int pos) {
        var size = directions.size();
        // we use the directions list like a ring buffer
        return directions.get((pos + size) % size);
    }

    public String asLetter() {
        return letter;
    }
}
