package com.alcano.blaze.animation;

import com.alcano.blaze.resource.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Animation {

    public final String key;
    public final float delay;
    public final List<Sprite> frames;

    public Animation(String key, float delay, List<Sprite> frames) {
        this.key = key;
        this.delay = delay;
        this.frames = frames;
    }

    public Animation(String key, float delay) {
        this(key, delay, new ArrayList<>());
    }

}
