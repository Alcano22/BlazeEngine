package com.alcano.blaze.math;

public final class Mathf {

    private Mathf() {}

    public static float lerp(float a, float b, float t) {
        return a + t * (b - a);
    }

}
