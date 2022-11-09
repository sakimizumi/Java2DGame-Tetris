package org.saki.game.core.ui.resource;

import org.saki.game.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ImageResource {
    private static ImageResource instance;
    public static ImageResource getInstance(){
        if(instance == null){
            instance = new ImageResource();
        }
        return instance;
    }
    public Image CUR_HAND;


    public void load(){

        CUR_HAND = getImageResource("image/cur.png");
    }

    public static Image getImageResource(String name){
        InputStream stream = Main.class.getResourceAsStream(name);
        try {
            return ImageIO.read(Objects.requireNonNull(stream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
