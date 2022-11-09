package org.saki.game.core.ui.resource;

import org.saki.game.core.ui.widget.View;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends View {
    private BufferedImage image;

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void Render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image,getStartX() - (getWidth() / 2),getStartY() - (getHeight() / 2),getWidth(),getHeight(),null);
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

}
