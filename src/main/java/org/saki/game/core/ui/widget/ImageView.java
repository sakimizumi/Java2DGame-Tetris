package org.saki.game.core.ui.widget;

import org.saki.game.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageView extends View {
    private BufferedImage image;
    public ImageView(String name){
//        image = ImageIO.read(Main.class.getResourceAsStream(name));
    }
    @Override
    public void Render(Graphics g) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }
}
