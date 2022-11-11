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
        if(BLOCK_X_START > CANVAS_X_START) {
            moveTo(getStartX() - OFFSET_WIDTH, getStartY());
        }
    }
    public void moveRight(){
        if(BLOCK_X_END < CANVAS_X_END){
            moveTo(getStartX() + OFFSET_WIDTH,getStartY());
        }
    }
    public void moveDown(){
        if(BLOCK_Y_END < CANVAS_Y_END){
            moveTo(getStartX(),getStartY() + OFFSET_HALF_HEIGHT);
        }
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
            moveDown();
            curTime = 0;
        }
    }
    ErsBlock type = BLOCK_T;

    int CANVAS_X_START = 0;
    int CANVAS_X_END = 0;
    int CANVAS_Y_END = 0;
    public GameBlock(int startX,int startY,int width,int height){
        int spawnX = startX + (GamePanel.COL / 2 *  GamePanel.BLOCK_SIZE);
        int spawnY = startY - GamePanel.BLOCK_SIZE;
        containerHeight = height;
        containerWidth = width;
        CANVAS_X_START = startX;
        CANVAS_X_END = startX + width;
        CANVAS_Y_END = startY + height;
        BLOCK_X_START = CANVAS_X_END;
        BLOCK_X_END = CANVAS_X_START;
        BLOCK_Y_END = CANVAS_Y_END - 1;
        OFFSET_WIDTH = containerWidth / GamePanel.COL;
        OFFSET_HEIGHT = containerHeight / GamePanel.ROW;
        OFFSET_HALF_WIDTH = OFFSET_WIDTH / 2;
        OFFSET_HALF_HEIGHT = OFFSET_HEIGHT / 2;
        this.setStartX(spawnX - OFFSET_HALF_WIDTH);
        this.setStartY(spawnY + OFFSET_HALF_HEIGHT);
    }

    int BLOCK_X_START = 0;
    int BLOCK_X_END = 0;
    int BLOCK_Y_END = 0;
    @Override
    public void Render(Graphics g) {
        for(Point point : type.points){
            int x = getStartX() + (point.x * SIZE);
            int y = getStartY() + (point.y * SIZE);
            int rect_x_start = x - OFFSET_HALF_WIDTH;
            int rect_x_end = rect_x_start + OFFSET_WIDTH;
            int rect_y_start = y - OFFSET_HALF_HEIGHT;
            int rect_y_end = rect_y_start + OFFSET_HEIGHT;
            if(BLOCK_X_START >= rect_x_start){
                BLOCK_X_START = rect_x_start;
            }
            if(BLOCK_X_END <= rect_x_end){
                BLOCK_X_END = rect_x_end;
            }
            if(BLOCK_Y_END <= rect_y_end){
                BLOCK_Y_END = rect_y_end;
            }
            g.fillRect(rect_x_start,rect_y_start,OFFSET_WIDTH,OFFSET_HEIGHT);
        }

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }


    public boolean isAvailable() {
        return true;
    }

    public void rotate(){

    }
}
