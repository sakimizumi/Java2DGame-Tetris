package org.saki.game.core.ui.widget;

import org.saki.game.core.ui.GamePanel;

import java.awt.*;
import java.util.LinkedList;

public class ScoreBoard extends View {
    private String[] scoreList = new String[10];
    private final int startX = GamePanel.WIDTH / 2 ;
    private final int startY = GamePanel.HEIGHT / 4;
    @Override
    public void Render(Graphics g) {
        for(int i = 0;i < scoreList.length;i++){
            String text = i+"."+scoreList[i];
            FontMetrics metrics = g.getFontMetrics();
            int width = metrics.stringWidth(text);
            int height = metrics.getHeight();
            g.drawString(text, startX - (width / 2), startY + GamePanel.BLOCK_SIZE * i );
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

    public void load() {
        scoreList[0] = ("SHICHIYU--------------------230");
        scoreList[1] = ("SHICHIYU--------------------210");
        scoreList[2] = ("SHICHIYU--------------------112");
        scoreList[3] = ("SHICHIYU--------------------099");
        scoreList[4] = ("----------------------------000");
        scoreList[5] = ("----------------------------000");
        scoreList[6] = ("----------------------------000");
        scoreList[7] = ("----------------------------000");
        scoreList[8] = ("----------------------------000");
        scoreList[9] = ("----------------------------000");
    }
}
