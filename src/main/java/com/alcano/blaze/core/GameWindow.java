package com.alcano.blaze.core;

import com.alcano.blaze.math.Vector2;
import com.alcano.blaze.scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameWindow extends JFrame {

    public final Canvas canvas;

    public GameWindow() {
        Engine.Settings settings = Engine.get().settings;

        this.setTitle(settings.windowTitle);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.canvas = new Canvas();
        this.canvas.setSize(settings.windowSize.toDimension());
        this.add(this.canvas);

        this.pack();

        this.setLocationRelativeTo(null);

        this.dispose();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);

        this.setVisible(true);
    }

    public Vector2 getWindowSize() {
        return new Vector2(this.canvas.getSize());
    }

    public void render() {
        BufferStrategy bs = this.canvas.getBufferStrategy();
        if (bs == null) {
            this.canvas.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.translate(this.getWindowSize().x / 2, this.getWindowSize().y / 2);
        ((Graphics2D) g).scale(1f, -1f);

        g.setColor(SceneManager.get().getCurrentScene().camera.backgroundColor);
        g.fillRect(-this.getWindowSize().x / 2, -this.getWindowSize().y / 2, this.getWindowSize().x, this.getWindowSize().y);

        SceneManager.get().render(g);

        bs.show();
        g.dispose();
    }

}
