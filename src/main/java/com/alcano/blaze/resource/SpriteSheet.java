package com.alcano.blaze.resource;

import com.alcano.blaze.math.Vector2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheet {

    public final List<Sprite> sprites = new ArrayList<>();

    public SpriteSheet(BufferedImage sourceImg, Vector2 cellSize, boolean ignoreEmptyCells) {
        for (int y = 0; y < sourceImg.getHeight(); y += cellSize.y) {
            for (int x = 0; x < sourceImg.getWidth(); x += cellSize.x) {
                Sprite sprite = new Sprite(sourceImg.getSubimage(x, y, cellSize.x, cellSize.y));

                if (ignoreEmptyCells && sprite.isBlank()) continue;

                this.sprites.add(sprite);
            }
        }
    }

    public SpriteSheet(BufferedImage sourceImg, Vector2 cellSize) {
        this(sourceImg, cellSize, true);
    }

    public Sprite get(int index) {
        return this.sprites.get(index);
    }

}
