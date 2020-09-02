package com.jayway.robot;

public class Robot {
    public static void main(String...args) {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException("need the movement commands!");
        }
        String commands = args[0];
        
    }
}
