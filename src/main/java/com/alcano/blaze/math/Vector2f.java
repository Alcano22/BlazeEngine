package com.alcano.blaze.math;

import java.awt.*;

public class Vector2f {

    public static Vector2f ZERO = new Vector2f(0f, 0f);
    public static Vector2f ONE = new Vector2f(1f, 1f);

    public float x;
    public float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(float x) {
        this(x, 0f);
    }

    public Vector2f() {
        this(0f, 0f);
    }

    public Vector2f(Point point) {
        this(point.x, point.y);
    }

    public Vector2f(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public Vector2f(Vector2 vec2) {
        this(vec2.x, vec2.y);
    }

    public static Vector2f moveTowards(Vector2f a, Vector2f b, float t) {
        float dx = b.x - a.x;
        float dy = b.y - a.y;
        float dir = (float) Math.atan2(dy, dx);
        float x = a.x + (t * (float) Math.cos(dir));
        float y = a.y + (t * (float) Math.sin(dir));
        return new Vector2f(x, y);
    }

    public static Vector2f lerp(Vector2f a, Vector2f b, float t) {
        float x = Mathf.lerp(a.x, b.x, t);
        float y = Mathf.lerp(a.y, b.y, t);
        return new Vector2f(x, y);
    }

    public Vector2f add(float x, float y) {
        return new Vector2f(this.x + x, this.y + y);
    }

    public Vector2f sub(float x, float y) {
        return new Vector2f(this.x - x, this.y - y);
    }

    public Vector2f mul(float x, float y) {
        return new Vector2f(this.x * x, this.y * y);
    }

    public Vector2f div(float x, float y) {
        return new Vector2f(this.x / x, this.y / y);
    }

    public Vector2f add(float i) {
        return this.add(i, i);
    }

    public Vector2f sub(float i) {
        return this.sub(i, i);
    }

    public Vector2f mul(float i) {
        return this.mul(i, i);
    }

    public Vector2f div(float i) {
        return this.div(i, i);
    }

    public Vector2f add(Vector2f vec2f) {
        return this.add(vec2f.x, vec2f.y);
    }

    public Vector2f sub(Vector2f vec2f) {
        return this.sub(vec2f.x, vec2f.y);
    }

    public Vector2f mul(Vector2f vec2f) {
        return this.mul(vec2f.x, vec2f.y);
    }

    public Vector2f div(Vector2f vec2f) {
        return this.div(vec2f.x, vec2f.y);
    }

    public void addSelf(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void subSelf(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void mulSelf(float x, float y) {
        this.x *= x;
        this.y *= y;
    }

    public void divSelf(float x, float y) {
        this.x *= x;
        this.y *= y;
    }

    public void addSelf(float f) {
        this.addSelf(f, f);
    }

    public void subSelf(float f) {
        this.subSelf(f, f);
    }

    public void mulSelf(float f) {
        this.mulSelf(f, f);
    }

    public void divSelf(float f) {
        this.divSelf(f, f);
    }

    public void addSelf(Vector2f vec2f) {
        this.addSelf(vec2f.x, vec2f.y);
    }

    public void subSelf(Vector2f vec2f) {
        this.subSelf(vec2f.x, vec2f.y);
    }

    public void mulSelf(Vector2f vec2f) {
        this.mulSelf(vec2f.x, vec2f.y);
    }

    public void divSelf(Vector2f vec2f) {
        this.divSelf(vec2f.x, vec2f.y);
    }

    public Point toPoint() {
        return new Vector2(this).toPoint();
    }

    public Dimension toDimension() {
        return new Vector2(this).toDimension();
    }

    public String toString() {
        return "(" + this.x + " " + this.y + ")";
    }

}
