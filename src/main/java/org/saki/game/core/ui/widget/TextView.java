package org.saki.game.core.ui.widget;

import java.awt.*;

public class TextView extends View{
    private String text;
    private final Font font;

    public TextView(String text){
        this(text,16);
    }
    public TextView(String text,int fontSize){
        this(text,new Font(null,Font.PLAIN,fontSize));
    }
    public TextView(String text,Font font){
        this.text = text;
        this.font = font;
    }

    @Override
    public void Render(Graphics g) {
         FontMetrics metrics = g.getFontMetrics(font);
         g.setColor(Color.WHITE);
         width = metrics.stringWidth(text);
         height = metrics.getHeight();
         g.drawString(text,getStartX(),getStartY());
    }
    private int width;
    private int height;
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setText(String text) {
        this.text = text;
    }
}
