package com.alcano.blaze.gameobject.component;

import com.alcano.blaze.animation.Animation;
import com.alcano.blaze.util.Debug;
import com.alcano.blaze.util.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animator extends Component {

    public final List<Animation> animations;

    private Animation currentAnimation;
    private int index;
    private float nextStepTime;

    public Animator(String startAnimation, List<Animation> animations) {
        this.animations = animations;
        this.setCurrentAnimation(startAnimation);
    }

    public Animator(String startAnimation, Animation... animations) {
        this(startAnimation, Arrays.asList(animations));
    }

    public Animator(String startKey) {
        this(startKey, new ArrayList<>());
    }

    @Override
    public void update() {
        if (Time.getTime() > this.nextStepTime) {
            this.nextStepTime = Time.getTime() + this.currentAnimation.delay;
            this.index++;
            if (this.currentAnimation.frames.size() <= this.index) {
                this.index = 0;
            }

            this.gameObject.getComponent(SpriteRenderer.class).sprite = this.currentAnimation.frames.get(this.index);
        }
    }

    public String getCurrentAnimation() {
        return this.currentAnimation.key;
    }

    public void setCurrentAnimation(String currentKey) {
        if (this.currentAnimation != null && this.currentAnimation.key != null) {
            if (this.currentAnimation.key.equals(currentKey)) return;
        }

        for (Animation animation : this.animations) {
            if (!animation.key.equals(currentKey)) continue;

            this.currentAnimation = animation;
            this.index = 0;
            this.nextStepTime = 0;
            return;
        }

        Debug.log("No animation called: '" + currentKey + "'", Debug.Level.WARNING);
    }
}
