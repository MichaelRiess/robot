package com.jayway.robot;

import java.util.List;

public enum Direction {
    facingNorth("N"), facingSouth("S"), facingWest("V"), facingEast("Ö");

    private static final List<Direction> directions = List.of(facingNorth, facingEast, facingSouth, facingWest);

    private final String letter;

    Direction(String letter) {
        this.letter = letter;
    }

    public Direction turnLeft() {
        var pos = directions.indexOf(this) - 1;
        return directions.get(pos < 0 ? directions.size() - 1 : pos);
    }

    public Direction turnRight() {
        var pos = directions.indexOf(this) + 1;
        return directions.get(pos == directions.size() ? 0 : pos);
    }

    public String asLetter() {
        return letter;
    }
}
