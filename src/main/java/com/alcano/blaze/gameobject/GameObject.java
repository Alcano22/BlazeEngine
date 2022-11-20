package com.alcano.blaze.gameobject;

import com.alcano.blaze.gameobject.component.Component;
import com.alcano.blaze.math.Vector2;
import com.alcano.blaze.scene.SceneManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameObject {

    private final List<Component> components = new ArrayList<>();

    public Transform transform;

    public GameObject(Transform transform) {
        this.transform = transform;
    }

    public GameObject() {
        this(new Transform());
    }

    public static void instantiate(GameObject gameObject) {
        SceneManager.get().getCurrentScene().addGameObject(gameObject);
    }

    public static void destroy(GameObject gameObject) {
        SceneManager.get().getCurrentScene().removeGameObject(gameObject);
    }

    public void update() {
        this.components.forEach(component -> {
            component.gameObject = this;
            component.transform = this.transform;
            component.update();
        });
    }

    public void render(Graphics g) {
        this.components.forEach(component -> {
            if (component.transform != null && component.gameObject != null) {
                component.render(g);
            }
        });
    }

    public <T extends Component> T[] getComponents(Class<T> componentClass) {
        List<T> matchingComponents = new ArrayList<>();
        for (Component component : this.components) {
            if (!component.getClass().isAssignableFrom(componentClass)) continue;

            matchingComponents.add(componentClass.cast(component));
        }

        return (T[]) matchingComponents.toArray(new Component[0]);
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        return getComponents(componentClass)[0];
    }

    public <T extends Component> T addComponent(T component) {
        if (!this.components.contains(component)) {
            this.components.add(component);

            return component;
        }

        return null;
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    public void removeComponent(Class<? extends Component> componentClass) {
        this.removeComponent(this.getComponents(componentClass)[0]);
    }

    public void removeComponents(Class<? extends Component> componentClass) {
        for (Component component : this.getComponents(componentClass)) {
            this.removeComponent(component);
        }
    }

}
