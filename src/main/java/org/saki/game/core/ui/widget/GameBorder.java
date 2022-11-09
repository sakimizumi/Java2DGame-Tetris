package org.saki.game.core.ui.widget;

import java.awt.*;

public class GameBorder extends View{
    int score = 0;
    Font font = new Font(null, Font.BOLD,15);
    public void Render(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(String.format("得分:%d",score),getStartX(),getStartY());
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    public void setScore(int score){
        this.score = score;
    }

}
