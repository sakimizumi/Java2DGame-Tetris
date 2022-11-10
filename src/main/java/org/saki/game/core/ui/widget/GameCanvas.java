package org.saki.game.core.ui.widget;

import org.saki.game.core.entity.GameBlock;
import org.saki.game.core.ui.GamePanel;

import java.awt.*;

public class GameCanvas {
    private int startX;
    private int startY;
    private int width;
    private int height;
    GameBlock block;

    public void setSize(int x,int y,int width,int height){
        startX = x;
        startY = y;
        this.width = width;
        this.height = height;
        block = new GameBlock(startX,startY,width,height);
    }

    public void Render(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(startX,startY,width,height);
        block.Render(g);
        int spawnX = startX + (GamePanel.COL / 2 *  GamePanel.BLOCK_SIZE);
        int spawnY = startY + (2 * GamePanel.BLOCK_SIZE);
        g.drawLine(spawnX, startY, spawnX, height + startY);
        g.drawLine(startX, spawnY, startX + width, spawnY);
    }

    public void Update() {
        block.Update();
    }
}
