package com.jayway.robot;

public interface Room {
    java.awt.Point getStartPosition();
    boolean contains(java.awt.Point position);
}
