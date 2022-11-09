package org.saki.game.core.ui.widget;

import java.awt.*;

public class GameCanvas {
    private int startX;
    private int startY;
    private int width;
    private int height;

    public void setSize(int x,int y,int width,int height){
        startX = x;
        startY = y;
        this.width = width;
        this.height = height;
    }

    public void Render(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(startX,startY,width,height);
    }
}
