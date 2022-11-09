package org.saki.game.core.ui.widget;

import java.awt.*;

public class ListItemView extends View {
    private final String title;
    private String value;
    private TextView titleView;
    private TextView valueView;
    public ListItemView(String title) {
        this(title, "",0);
    }
    private int width = 0;

    public void setWidth(int width) {
        this.width = width;
    }

    public ListItemView(String title, String value ,int width) {
        this.title = title;
        this.value = value;
        titleView = new TextView(title);
        valueView = new TextView(value);
        this.width = width;
    }

    public void setValue(String text) {
        valueView.setText(text);
    }

    @Override
    public void Render(Graphics g) {
        if(width != 0){
            titleView.Render(g);
            valueView.Render(g);
        }

    }

    @Override
    public void setPos(int startX, int startY) {
        super.setPos(startX, startY);
        titleView.setPos(getStartX(),getStartY());
        valueView.setPos(getStartX() + width ,getStartY());
    }

    @Override
    public int getHeight() {
        return titleView.getHeight();
    }

    @Override
    public int getWidth() {
        return width + valueView.getWidth();
    }

    public void selected(CursorView cursorView){
        cursorView.setLocation(valueView);
    }
}
