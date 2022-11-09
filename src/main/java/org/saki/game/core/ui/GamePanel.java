package org.saki.game.core.ui;

import org.saki.game.core.StateMachine;
import org.saki.game.core.ui.stage.*;
import org.saki.game.core.ui.widget.HUD;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int ROW = 20;
    public static final int COL = 10;
    public static final int BLOCK_SIZE = 32;
    public static final int WIDTH = (int) (COL * BLOCK_SIZE * 1.5);
    public static final int HEIGHT = (ROW + 2) * BLOCK_SIZE;
    public static final int FPS = 60;

    public void init() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        stateMachine = new StateMachine();
        this.addKeyListener(stateMachine.keyHandler);
        stateMachine.Add("MENU", new MenuState(stateMachine));
        stateMachine.Add("GAME", new GameState(stateMachine));
        stateMachine.Add("SETTING", new SettingState(stateMachine));
        stateMachine.Add("SCORE", new ScoreState(stateMachine));
        addMouseMotionListener(debug);
        addMouseListener(debug);
    }

    Thread thread;
    StateMachine stateMachine;

    public void startGameThread() {
        thread = new Thread(this);
        thread.start();
        stateMachine.Change("MENU");
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (thread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                stateMachine.Update();
                this.repaint();
                delta--;
            }

        }

    }
    private HUD.Debug debug = new HUD.Debug();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        stateMachine.Render(g);
        debug.Render(g);
    }
}
