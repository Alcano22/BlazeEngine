package com.alcano.blaze.scene;

import com.alcano.blaze.core.Engine;
import com.alcano.blaze.core.GameWindow;
import com.alcano.blaze.math.Vector2;
import com.alcano.blaze.math.Vector2f;

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

    public Vector2f screenToWorldPos(Vector2 screenPos) {
        GameWindow gameWindow = Engine.get().gameWindow;
        float x = (screenPos.x - gameWindow.getWindowSize().x / 2f) / this.fov;
        float y = -(screenPos.y - gameWindow.getWindowSize().y / 2f) / this.fov;
        return new Vector2f(x, y);
    }

}
