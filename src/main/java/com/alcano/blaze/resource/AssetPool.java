package com.alcano.blaze.resource;

import com.alcano.blaze.audio.Sound;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AssetPool {

    private static AssetPool instance;

    private final Map<String, BufferedImage> textures = new HashMap<>();
    private final Map<String, Clip> audioClips = new HashMap<>();

    private AssetPool() {}

    public static BufferedImage loadTexture(String path) {
        if (get().textures.containsKey(path)) {
            return get().textures.get(path);
        }

        try {
            BufferedImage texture =  ImageIO.read(new File("assets/" + path));
            get().textures.put(path, texture);
            return texture;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Sprite loadSprite(String path) {
        return new Sprite(loadTexture(path));
    }

    public static Clip loadAudioClip(String path) {
        if (get().audioClips.containsKey(path)) {
            return get().audioClips.get(path);
        }

        try {
            Clip audioClip = AudioSystem.getClip();
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("assets/" + path));
            audioClip.open(audioIn);

            get().audioClips.put(path, audioClip);
            return audioClip;
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Sound loadSound(String path) {
        return new Sound(loadAudioClip(path));
    }

    public static AssetPool get() {
        if (instance == null) {
            instance = new AssetPool();
        }

        return instance;
    }

}
