package com.alcano.blaze.gameobject;

import com.alcano.blaze.math.Vector2f;

public class Transform {

    public Vector2f position;
    public float rotation;
    public Vector2f scale;

    public Transform(Vector2f position, float rotation, Vector2f scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Transform(Vector2f position, float rotation) {
        this(position, rotation, new Vector2f(1f, 1f));
    }

    public Transform(Vector2f position, Vector2f scale) {
        this(position, 0f, scale);
    }

    public Transform(Vector2f position) {
        this(position, 0f);
    }

    public Transform() {
        this(Vector2f.ZERO);
    }

}
