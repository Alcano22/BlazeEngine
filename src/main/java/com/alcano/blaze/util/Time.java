package com.alcano.blaze.util;

public final class Time {

    public static float deltaTime;

    private Time() {}

    public static float getTime() {
        return System.nanoTime() / 1000000000f;
    }

}
