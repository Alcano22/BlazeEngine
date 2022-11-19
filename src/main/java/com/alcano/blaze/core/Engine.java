package com.alcano.blaze.core;

import com.alcano.blaze.api.BlazeGame;
import com.alcano.blaze.math.Vector2;
import com.alcano.blaze.scene.Scene;
import com.alcano.blaze.scene.SceneManager;
import com.alcano.blaze.util.Input;
import com.alcano.blaze.util.Time;

import java.awt.event.KeyEvent;

public class Engine {

    private static Engine instance;

    public final BlazeGame game;
    public final Settings settings;
    public final SceneManager sceneManager;
    public final GameWindow gameWindow;

    private Thread mainThread;
    private boolean running;

    public Engine(BlazeGame game) {
        instance = this;

        this.game = game;
        this.settings = game.getSettings();
        this.sceneManager = new SceneManager();
        this.gameWindow = new GameWindow();

        new Scene("Game");

        game.createScenes();
        game.init();

        this.start();
    }

    public synchronized void start() {
        this.mainThread = new Thread(this::run, "Main Thread");
        this.mainThread.start();
        this.running = true;
    }

    public synchronized void stop() {
        try {
            this.mainThread.join();
            this.running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long last = System.nanoTime();
        double numTicks = 60.0;
        double ns = 1000000000 / numTicks;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (this.running) {
            long now = System.nanoTime();
            Time.deltaTime += (now - last) / ns;
            last = now;
            while (Time.deltaTime >= 1) {
                this.update();
                Time.deltaTime--;
            }
            if (this.running) {
                this.render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        this.stop();
    }

    public void update() {
        this.gameWindow.requestFocus();

        if (Input.getKey(KeyEvent.VK_ESCAPE)) {
            System.exit(0);
        }

        this.sceneManager.update();
    }

    public void render() {
        this.gameWindow.render();
    }

    public static Engine get() {
        return instance;
    }

    public static class Settings {
        public Vector2 windowSize = new Vector2(1920, 1080);
        public String windowTitle = "Sample Game";
        public boolean debug;

        public Settings windowSize(Vector2 size) {
            this.windowSize = size;
            return this;
        }

        public Settings windowTitle(String title) {
            this.windowTitle = title;
            return this;
        }

        public Settings debug(boolean debug) {
            this.debug = debug;
            return this;
        }
    }

}
