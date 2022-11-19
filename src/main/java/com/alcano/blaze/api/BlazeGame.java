package com.alcano.blaze.api;

import com.alcano.blaze.core.Engine;

public abstract class BlazeGame {

    public abstract void createScenes();
    public abstract void init();
    public abstract Engine.Settings getSettings();

}
