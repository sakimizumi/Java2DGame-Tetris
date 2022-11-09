package org.saki.game.core.ui.widget;

import org.saki.game.core.GameConst;
import org.saki.game.core.ui.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HUD {
    public static class Debug extends View implements MouseMotionListener, MouseListener {
        private int mouseX;
        private int mouseY;

        private boolean isPress = false;
        private Font font = new Font("DEBUG", Font.PLAIN, 12);

        @Override
        public void Render(Graphics g) {
            if (GameConst.DEBUG) {
                g.setColor(Color.GRAY);
                g.setFont(font);
                g.drawLine(mouseX, 0, mouseX, GamePanel.HEIGHT);
                g.drawLine(0, mouseY, GamePanel.WIDTH, mouseY);
                String text = "(" + mouseX + "," + mouseY + ") " + (isPress ? "Press" : "");
                g.drawString(text,mouseX + 10,mouseY -10);
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

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            isPress = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            isPress = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
