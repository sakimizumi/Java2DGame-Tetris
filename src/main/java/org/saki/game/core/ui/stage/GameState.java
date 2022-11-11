package org.saki.game.core.ui.stage;

import org.saki.game.Main;
import org.saki.game.core.IState;
import org.saki.game.core.StateMachine;
import org.saki.game.core.entity.GameBlock;
import org.saki.game.core.ui.GamePanel;
import org.saki.game.core.ui.resource.Sprite;
import org.saki.game.core.ui.resource.SpriteSheet;
import org.saki.game.core.ui.widget.GameBorder;
import org.saki.game.core.ui.widget.GameCanvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameState implements IState {
    StateMachine stateMachine;
    GameCanvas canvas;
    GameBorder border = new GameBorder();
    public GameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;

    }

    @Override
    public void Update() {
        GameBlock block = canvas.getBlock();
        if(block != null && block.isAvailable()){
            if(stateMachine.keyHandler.isPRESS_LEFT()){
                block.moveLeft();
            }else if(stateMachine.keyHandler.isPRESS_RIGHT()){
                block.moveRight();
            }
        }

        canvas.Update();
    }

    @Override
    public void Render(Graphics g) {

        canvas.Render(g);
        border.Render(g);

    }

    @Override
    public void OnEnter() {
        canvas = new GameCanvas();
        canvas.setSize(GamePanel.BLOCK_SIZE,GamePanel.BLOCK_SIZE,GamePanel.BLOCK_SIZE * GamePanel.COL,GamePanel.BLOCK_SIZE * GamePanel.ROW);
        border.setPos(GamePanel.BLOCK_SIZE * (GamePanel.COL + 2), GamePanel.BLOCK_SIZE * 3);
    }

    @Override
    public void OnExit() {

    }
}
