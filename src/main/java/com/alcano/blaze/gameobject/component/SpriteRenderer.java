package com.alcano.blaze.gameobject.component;

import com.alcano.blaze.resource.Sprite;

import java.awt.*;

public class SpriteRenderer extends Component {

    public Sprite sprite;
    public Color color;

    public SpriteRenderer(Sprite sprite, Color color) {
        this.sprite = sprite;
        this.color = color;
    }

    public SpriteRenderer(Sprite sprite) {
        this(sprite, Color.WHITE);
    }

    public SpriteRenderer(Color color) {
        this(null, color);
    }

    @Override
    public void render(Graphics g) {
        int width = (int) (this.transform.scale.x * this.getCamera().fov);
        int height = (int) (this.transform.scale.y * this.getCamera().fov);
        int x = (int) (this.transform.position.x * this.getCamera().fov - width / 2f);
        int y = (int) (this.transform.position.y * this.getCamera().fov - height / 2f);

        float radians = (float) Math.toRadians(-this.transform.rotation);
        ((Graphics2D) g).rotate(radians, this.transform.position.x * this.getCamera().fov, this.transform.position.y * this.getCamera().fov);

        g.setColor(this.color);
        if (this.sprite == null) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawImage(this.sprite.texture, x, y, width, height, this.color, null);
        }

        ((Graphics2D) g).rotate(-radians, this.transform.position.x * this.getCamera().fov, this.transform.position.y * this.getCamera().fov);
    }
}
