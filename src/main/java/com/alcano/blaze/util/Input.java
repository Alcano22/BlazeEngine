package com.alcano.blaze.util;

import com.alcano.blaze.core.Engine;
import com.alcano.blaze.core.GameWindow;
import com.alcano.blaze.math.Axis;
import com.alcano.blaze.math.Vector2;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class Input implements KeyListener, MouseListener {

    private static final int NUM_KEYS = 255;
    private static final int NUM_MOUSE_BUTTONS = 5;

    private static Input instance;

    private final boolean[] keysPressed = new boolean[NUM_KEYS];
    private final boolean[] keysCurrent = new boolean[NUM_KEYS];
    private final boolean[] keysDown = new boolean[NUM_KEYS];
    private final boolean[] keysUp = new boolean[NUM_KEYS];
    private final boolean[] mousePressed = new boolean[NUM_MOUSE_BUTTONS];
    private final boolean[] mouseCurrent = new boolean[NUM_MOUSE_BUTTONS];
    private final boolean[] mouseDown = new boolean[NUM_MOUSE_BUTTONS];
    private final boolean[] mouseUp = new boolean[NUM_MOUSE_BUTTONS];

    public static Vector2 mousePosition;

    private Input() {
        Canvas gameCanvas = Engine.get().gameWindow.canvas;
        gameCanvas.addKeyListener(this);
        gameCanvas.addMouseListener(this);
    }

    public void update() {
        Arrays.fill(this.keysUp, false);
        for (int i = 0; i < NUM_KEYS; i++) {
            if (!getKeyPressed(i) && this.keysCurrent[i]) {
                this.keysUp[i] = true;
            }
        }

        Arrays.fill(this.keysDown, false);
        for (int i = 0; i < NUM_KEYS; i++) {
            if (getKeyPressed(i) && !this.keysCurrent[i]) {
                this.keysDown[i] = true;
            }
        }

        Arrays.fill(this.keysCurrent, false);
        for (int i = 0; i < NUM_KEYS; i++) {
            if (getKeyPressed(i)) {
                this.keysCurrent[i] = true;
            }
        }

        Arrays.fill(this.mouseUp, false);
        for (int i = 0; i < NUM_MOUSE_BUTTONS; i++) {
            if (!getMousePressed(i) && this.mouseCurrent[i]) {
                this.mouseUp[i] = true;
            }
        }

        Arrays.fill(this.mouseDown, false);
        for (int i = 0; i < NUM_MOUSE_BUTTONS; i++) {
            if (getMousePressed(i) && !this.mouseCurrent[i]) {
                this.mouseDown[i] = true;
            }
        }

        Arrays.fill(this.mouseCurrent, false);
        for (int i = 0; i < NUM_MOUSE_BUTTONS; i++) {
            if (getMousePressed(i)) {
                this.mouseCurrent[i] = true;
            }
        }

        mousePosition = new Vector2(MouseInfo.getPointerInfo().getLocation());
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

    @Override
    public void mousePressed(MouseEvent e) {
        this.mousePressed[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.mousePressed[e.getButton()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private static boolean getKeyPressed(int key) {
        return get().keysPressed[key];
    }

    public static boolean getKey(int key) {
        return get().keysCurrent[key];
    }

    public static boolean getKeyDown(int key) {
        return get().keysDown[key];
    }

    public static boolean getKeyUp(int key) {
        return get().keysUp[key];
    }

    private static boolean getMousePressed(int key) {
        return get().mousePressed[key];
    }

    public static boolean getMouse(int key) {
        return get().mouseCurrent[key];
    }

    public static boolean getMouseDown(int key) {
        return get().mouseDown[key];
    }

    public static boolean getMouseUp(int key) {
        return get().mouseUp[key];
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
