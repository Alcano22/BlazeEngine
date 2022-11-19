package com.alcano.blaze.gameobject.component;

import com.alcano.blaze.gameobject.GameObject;
import com.alcano.blaze.gameobject.Transform;
import com.alcano.blaze.scene.Camera;
import com.alcano.blaze.scene.SceneManager;

import java.awt.*;

public abstract class Component {

    public GameObject gameObject;
    public Transform transform;

    public void update() {}
    public void render(Graphics g) {}

    protected Camera getCamera() {
        return SceneManager.get().getCurrentScene().camera;
    }

}
