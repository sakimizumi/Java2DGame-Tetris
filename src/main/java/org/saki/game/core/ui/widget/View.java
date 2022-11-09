package org.saki.game.core.ui.widget;

import java.awt.*;

public abstract class View {

    private int startX = 0;
    private int startY = 0;
    public abstract void Render(Graphics g);


    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setPos(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public abstract int getHeight();
    public abstract int getWidth();
    protected View location;
    public void setLocation(View view){
        this.location = view;
    }
}
