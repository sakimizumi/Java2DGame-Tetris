package org.saki.game.core.ui;

import org.saki.game.core.GameConst;
import org.saki.game.core.ui.resource.ImageResource;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    GamePanel panel = new GamePanel();
    public void init(String[] args){
        panel = new GamePanel();
        panel.init();
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setName(GameConst.APP_NAME);
        this.setTitle(GameConst.APP_NAME);
        this.setLocationRelativeTo(null);
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(ImageResource.getInstance().CUR_HAND,new Point(1,1),"HAND"));
        this.setVisible(true);
    }

    public void start(){
        panel.startGameThread();

    }
}
