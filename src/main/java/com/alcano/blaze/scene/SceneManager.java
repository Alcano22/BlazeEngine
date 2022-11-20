package com.alcano.blaze.scene;

import com.alcano.blaze.core.Engine;
import com.alcano.blaze.util.Debug;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SceneManager {

    public final List<Scene> scenes = new ArrayList<>();

    private Scene currentScene;

    public void loadScene(int sceneId) {
        if (this.scenes.size() < sceneId) {
            Debug.log("There is no scene with the following id: " + sceneId , Debug.Level.ERROR);
            System.exit(1);
        }
        this.currentScene = scenes.get(sceneId);
    }

    public void update() {
        this.currentScene.update();
    }

    public void render(Graphics g) {
        this.currentScene.render(g);
    }

    public void registerScene(Scene scene) {
        if (this.scenes.isEmpty()) {
            this.currentScene = scene;
        }

        this.scenes.add(scene);
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public static SceneManager get() {
        return Engine.get().sceneManager;
    }

}
