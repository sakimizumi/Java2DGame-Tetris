package org.saki.game.core.entity;

import org.saki.game.core.ui.GamePanel;
import org.saki.game.core.ui.widget.View;

import java.awt.*;

public class GameBlock extends View{
    private final int Duration = GamePanel.FPS;
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

    /**
     *
     * [
     *  [ 0, 0, 1, 1],
     *  [ 0, 0, 1, 1],
     *  [ 0, 0, 0, 0],
     *  [ 0, 0, 0, 0],
     * ]
     *
     * [[ 0, 0, 0, 1],  [[ 1, 1, 1, 1],
     *  [ 0, 0, 0, 1],   [ 0, 0, 0, 0],
     *  [ 0, 0, 0, 1],   [ 0, 0, 0, 0],
     *  [ 0, 0, 0, 1],]  [ 0, 0, 0, 0],]
     *
     * [[ 0, 0, 1, 1],  [[ 0, 0, 0, 0], [[ 0, 1, 0, 0],  [[ 0, 1, 1, 1],
     *  [ 0, 0, 0, 1],   [ 0, 0, 0, 1],  [ 0, 1, 0, 0],   [ 0, 1, 0, 0],
     *  [ 0, 0, 0, 1],   [ 0, 1, 1, 1],  [ 0, 1, 1, 0],   [ 0, 0, 0, 0],
     *  [ 0, 0, 0, 0],]  [ 0, 0, 0, 0],] [ 0, 0, 0, 0],]  [ 0, 0, 0, 0],]
     *
     * [[ 0, 1, 1, 1],  [[ 0, 0, 0, 1], [[ 0, 0, 0, 0],  [[ 0, 1, 0, 0],
     *  [ 0, 0, 1, 0],   [ 0, 0, 1, 1],  [ 0, 0, 1, 0],   [ 0, 1, 1, 0],
     *  [ 0, 0, 0, 0],   [ 0, 0, 0, 1],  [ 0, 1, 1, 1],   [ 0, 1, 0, 0],
     *  [ 0, 0, 0, 0],]  [ 0, 0, 0, 0],] [ 0, 0, 0, 0],]  [ 0, 0, 0, 0],]
     *
     * [[ 0, 1, 1, 1],  [[ 0, 0, 0, 1], [[ 0, 0, 0, 0],  [[ 0, 1, 0, 0],
     *  [ 0, 0, 1, 0],   [ 0, 0, 1, 1],  [ 0, 0, 1, 0],   [ 0, 1, 1, 0],
     *  [ 0, 0, 0, 0],   [ 0, 0, 0, 1],  [ 0, 1, 1, 1],   [ 0, 1, 0, 0],
     *  [ 0, 0, 0, 0],]  [ 0, 0, 0, 0],] [ 0, 0, 0, 0],]  [ 0, 0, 0, 0],]
     */


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
