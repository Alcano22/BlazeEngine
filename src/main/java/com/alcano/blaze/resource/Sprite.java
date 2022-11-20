package com.alcano.blaze.resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Sprite {

    public final BufferedImage texture;

    public Sprite(BufferedImage texture) {
        this.texture = texture;
    }

    public Sprite flipped(boolean flipX, boolean flipY) {
        BufferedImage flipped = new BufferedImage(this.texture.getWidth(),
                this.texture.getHeight(), this.texture.getType());
        AffineTransform tran = AffineTransform.getTranslateInstance(flipX ? this.texture.getWidth() : 0.0,
                flipY ? this.texture.getHeight() : 0.0);
        AffineTransform flip = AffineTransform.getScaleInstance(flipX ? -1.0 : 1.0, flipY ? -1.0 : 1.0);
        tran.concatenate(flip);
        Graphics2D g2d = flipped.createGraphics();
        g2d.setTransform(tran);
        g2d.drawImage(this.texture, 0, 0, null);
        g2d.dispose();

        return new Sprite(flipped);
    }

    public Sprite recolored(Color color) {
        float[][] colorMatrix = {
                { ((float) color.getRed()) / 255f, 0f, 0f, 0f },
                { ((float) color.getGreen()) / 255f, 0f, 0f, 0f },
                { ((float) color.getBlue()) / 255f, 0f, 0f, 0f, },
                { 0f, 0f, 0f, 1f } };
        BandCombineOp changeColors = new BandCombineOp(colorMatrix, null);
        Raster raster = this.texture.getRaster();
        WritableRaster writableRaster = raster.createCompatibleWritableRaster();
        changeColors.filter(raster, writableRaster);
        return new Sprite(new BufferedImage(this.texture.getColorModel(), writableRaster, true, null));
    }

    public static boolean match(Sprite a, Sprite b) {
        return Arrays.equals(a.getPixels(), b.getPixels());
    }

    public boolean isBlank() {
        BufferedImage blankImg = new BufferedImage(this.texture.getWidth(), this.texture.getHeight(), this.texture.getType());

        return match(this, new Sprite(blankImg));
    }

    public byte[] getPixels() {
        byte[] imageInByte = null;
        String format = "png";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(this.texture, format, baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageInByte;
    }

}
