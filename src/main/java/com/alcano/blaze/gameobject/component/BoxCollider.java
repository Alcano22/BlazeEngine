package com.alcano.blaze.gameobject.component;

import com.alcano.blaze.core.Engine;

import java.awt.*;

public class BoxCollider extends Component {

    @Override
    public void render(Graphics g) {
        if (Engine.get().settings.debug) {
            int width = (int) (this.transform.scale.x * this.getCamera().fov);
            int height = (int) (this.transform.scale.y * this.getCamera().fov);
            int x = (int) (this.transform.position.x * this.getCamera().fov - width / 2f);
            int y = (int) (this.transform.position.y * this.getCamera().fov - height / 2f);

            float radians = (float) Math.toRadians(-this.transform.rotation);
            ((Graphics2D) g).rotate(radians, this.transform.position.x * this.getCamera().fov, this.transform.position.y * this.getCamera().fov);

            g.setColor(Color.GREEN);
            g.drawRect(x, y, width, height);

            ((Graphics2D) g).rotate(-radians, this.transform.position.x * this.getCamera().fov, this.transform.position.y * this.getCamera().fov);
        }
    }
}
