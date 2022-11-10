package org.saki.game.core.entity;

import org.saki.game.core.ui.GamePanel;
import org.saki.game.core.ui.widget.View;

import java.awt.*;

import static org.saki.game.core.entity.ErsBlock.*;

public class GameBlock extends View{
    private final int Duration = GamePanel.FPS;

    int SIZE = GamePanel.BLOCK_SIZE;
    int OFFSET_HALF_WIDTH = 0;
    int OFFSET_HALF_HEIGHT = 0;
    int OFFSET_WIDTH = 0;
    int OFFSET_HEIGHT = 0;
    private int curTime = 0;
    public void moveLeft(){
        moveTo(getStartX() - GamePanel.BLOCK_SIZE,getStartY());
    }
    public void moveRight(){
        moveTo(getStartX() + GamePanel.BLOCK_SIZE,getStartY());
    }
    public void moveDown(){
        moveTo(getStartX(),getStartY() + GamePanel.BLOCK_SIZE);
    }
    private int containerHeight;
    private int containerWidth;
    private void moveTo(int x, int y) {
        this.setStartX(x);
        this.setStartY(y);
    }
    public void Update() {
        curTime++;
        if(curTime > Duration){
//            moveDown();
            curTime = 0;
        }
    }
    ErsBlock type = BLOCK_O;
    public GameBlock(int startX,int startY,int width,int height){
        int spawnX = startX + (GamePanel.COL / 2 *  GamePanel.BLOCK_SIZE);
        int spawnY = startY + (2 * GamePanel.BLOCK_SIZE);
        containerHeight = height;
        containerWidth = width;
        this.setStartX(spawnX);
        this.setStartY(spawnY);
        OFFSET_WIDTH = containerWidth / GamePanel.COL;
        OFFSET_HEIGHT = containerHeight / GamePanel.ROW;
        OFFSET_HALF_WIDTH = OFFSET_WIDTH / 2;
        OFFSET_HALF_HEIGHT = OFFSET_HEIGHT / 2;
    }

    @Override
    public void Render(Graphics g) {
//        for(Point point : type.points){
//            int x = getStartX() + (point.x * SIZE);
//            int y = getStartY() + (point.y * SIZE);
//            g.drawRect(x, y, x, y);
//        }
            g.drawRect(getStartX() - OFFSET_HALF_WIDTH,getStartY() - OFFSET_HALF_HEIGHT,OFFSET_WIDTH,OFFSET_HEIGHT);
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
