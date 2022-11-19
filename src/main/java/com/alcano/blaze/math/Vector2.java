package com.alcano.blaze.math;

import java.awt.*;

public class Vector2 {

    public static Vector2 ZERO = new Vector2(0, 0);
    public static Vector2 ONE = new Vector2(1, 1);

    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(int x) {
        this(x, 0);
    }

    public Vector2() {
        this(0, 0);
    }

    public Vector2(Vector2f vec2f) {
        this((int) vec2f.x, (int) vec2f.y);
    }

    public Vector2(Point point) {
        this(point.x, point.y);
    }

    public Vector2(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public Vector2 add(int x, int y) {
        return new Vector2(this.x + x, this.y + y);
    }

    public Vector2 sub(int x, int y) {
        return new Vector2(this.x - x, this.y - y);
    }

    public Vector2 mul(int x, int y) {
        return new Vector2(this.x * x, this.y * y);
    }

    public Vector2 div(int x, int y) {
        return new Vector2(this.x / x, this.y / y);
    }

    public Vector2 add(int i) {
        return this.add(i, i);
    }

    public Vector2 sub(int i) {
        return this.sub(i, i);
    }

    public Vector2 mul(int i) {
        return this.mul(i, i);
    }

    public Vector2 div(int i) {
        return this.div(i, i);
    }

    public Vector2 add(Vector2 vec2) {
        return this.add(vec2.x, vec2.y);
    }

    public Vector2 sub(Vector2 vec2) {
        return this.sub(vec2.x, vec2.y);
    }

    public Vector2 mul(Vector2 vec2) {
        return this.mul(vec2.x, vec2.y);
    }

    public Vector2 div(Vector2 vec2) {
        return this.div(vec2.x, vec2.y);
    }

    public void addSelf(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void subSelf(int x, int y) {
        this.x -= x;
        this.y -= y;
    }

    public void mulSelf(int x, int y) {
        this.x *= x;
        this.y *= y;
    }

    public void divSelf(int x, int y) {
        this.x /= x;
        this.y /= y;
    }

    public void addSelf(int i) {
        this.addSelf(i, i);
    }

    public void subSelf(int i) {
        this.subSelf(i, i);
    }

    public void mulSelf(int i) {
        this.mulSelf(i, i);
    }

    public void divSelf(int i) {
        this.divSelf(i, i);
    }

    public void addSelf(Vector2 vec2) {
        this.addSelf(vec2.x, vec2.y);
    }

    public void subSelf(Vector2 vec2) {
        this.subSelf(vec2.x, vec2.y);
    }

    public void mulSelf(Vector2 vec2) {
        this.mulSelf(vec2.x, vec2.y);
    }

    public void divSelf(Vector2 vec2) {
        this.divSelf(vec2.x, vec2.y);
    }

    public Point toPoint() {
        return new Point(this.x, this.y);
    }

    public Dimension toDimension() {
        return new Dimension(this.x, this.y);
    }
}
