package org.saki.game.core.ui.widget;

import java.awt.*;

public class CursorView extends View {
    private final int maxValue = 255;
    private int valueIndex = maxValue;
    private boolean lowDirValue = true;
    private int padding = 8;

    @Override
    public void Render(Graphics g) {
        if (location != null) {
            if (lowDirValue) {
                valueIndex--;
            } else {
                valueIndex++;
            }
            checkColorDir();
            g.setColor(new Color(valueIndex, valueIndex, valueIndex));
            g.drawRect(location.getStartX() - padding,
                    location.getStartY() - location.getHeight(),
                    location.getWidth() + padding * 2,
                    location.getHeight() + padding);
        }
    }

    @Override
    public int getHeight() {
        return location.getHeight() + padding * 2;
    }

    @Override
    public int getWidth() {
        return location.getWidth() + padding * 2;
    }

    private void checkColorDir() {
        int minValue = 150;
        if (valueIndex <= minValue) {
            lowDirValue = false;
            valueIndex = minValue;
        } else if (valueIndex >= maxValue) {
            lowDirValue = true;
            valueIndex = maxValue;
        }
    }
}
