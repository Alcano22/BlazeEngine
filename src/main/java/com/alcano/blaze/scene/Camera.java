package com.alcano.blaze.scene;

import java.awt.*;

public class Camera {

    public Color backgroundColor;
    public float fov;

    public Camera(Color backgroundColor, float fov) {
        this.backgroundColor = backgroundColor;
        this.fov = fov;
    }

    public Camera(Color backgroundColor) {
        this(backgroundColor, 50f);
    }

    public Camera() {
        this(new Color(42, 48, 73));
    }

}
