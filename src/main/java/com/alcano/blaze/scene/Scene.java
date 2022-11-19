package com.alcano.blaze.scene;

import com.alcano.blaze.gameobject.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    public final String name;
    public final Camera camera;

    private final List<GameObject> gameObjects = new ArrayList<>();

    public Scene(String name) {
        this.name = name;
        this.camera = new Camera();

        SceneManager.get().registerScene(this);
    }

    public void update() {
        this.gameObjects.forEach(GameObject::update);
    }

    public void render(Graphics g) {
        this.gameObjects.forEach(gameObject -> gameObject.render(g));
    }

    public void addGameObject(GameObject gameObject) {
        if (this.gameObjects.contains(gameObject)) return;

        this.gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

}
