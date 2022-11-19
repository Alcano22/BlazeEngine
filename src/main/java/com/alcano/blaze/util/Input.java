package com.alcano.blaze.util;

import com.alcano.blaze.core.Engine;
import com.alcano.blaze.core.GameWindow;
import com.alcano.blaze.math.Axis;
import com.alcano.blaze.math.Vector2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private static Input instance;

    private final boolean[] keysPressed = new boolean[255];

    private Input() {
        GameWindow gameWindow = Engine.get().gameWindow;
        gameWindow.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keysPressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keysPressed[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static boolean getKey(int key) {
        return get().keysPressed[key];
    }

    public static int getAxis(Axis axis) {
        switch (axis) {
            case HORIZONTAL:
                if (getKey(KeyEvent.VK_A)) return -1;
                if (getKey(KeyEvent.VK_D)) return 1;
                break;
            case VERTICAL:
                if (getKey(KeyEvent.VK_W)) return 1;
                if (getKey(KeyEvent.VK_S)) return -1;
                break;
        }
        return 0;
    }

    public static Vector2 getAxis() {
        return new Vector2(getAxis(Axis.HORIZONTAL), getAxis(Axis.VERTICAL));
    }

    public static Input get() {
        if (instance == null) {
            instance = new Input();
        }

        return instance;
    }

}
