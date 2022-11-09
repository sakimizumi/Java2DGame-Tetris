package org.saki.game.core.ui.stage;

import org.saki.game.core.IState;
import org.saki.game.core.StateMachine;
import org.saki.game.core.sound.SoundEffect;
import org.saki.game.core.ui.GamePanel;
import org.saki.game.core.ui.widget.CursorView;
import org.saki.game.core.ui.widget.TextView;

import java.awt.*;

public class MenuState implements IState {
    StateMachine stateMachine;
    int index = 1;
    String[] menu = new String[]{"退出","设置","排行","开始游戏"};
    private CursorView cursor;
    private SoundEffect soundEffect;
    public MenuState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        textViews = new TextView[menu.length];
        for(int i = 0; i < menu.length; i++ ){
            TextView textView = new TextView(menu[i]);
            textView.setPos(GamePanel.BLOCK_SIZE,GamePanel.HEIGHT - GamePanel.BLOCK_SIZE * (1 + i));
            textViews[i] = textView;
        }
        cursor = new CursorView();
        cursor.setLocation(textViews[textViews.length-1]);
        soundEffect = new SoundEffect("sound/click.wav");
    }

    @Override
    public void Update() {
        if(stateMachine.keyHandler.isPRESS_UP()){
            if(++index > menu.length - 1){
                index = menu.length - 1;
            }
            soundEffect.startFromHead();
        }else if(stateMachine.keyHandler.isPRESS_DOWN()){
            if(--index < 1){
                index = 0;
            }
            soundEffect.startFromHead();
        }else if(stateMachine.keyHandler.isPRESS_OK()){
            switch (index){
                case 0 -> System.exit(0);
                case 1 -> stateMachine.Change("SETTING");
                case 2 -> stateMachine.Change("SCORE");
                case 3 -> stateMachine.Change("GAME");
            }
        }
        for(int i = 0; i < textViews.length; i++ ){
            if(index == i){
                cursor.setLocation(textViews[i]);
            }

        }
    }

    @Override
    public void Render(Graphics g) {
        g.setFont(new Font("TITLE",Font.PLAIN,16));
        g.setColor(Color.WHITE);
        for (TextView textView : textViews) {
            textView.Render(g);
        }
        g.setFont(new Font("SEC_TITLE",Font.BOLD,32));
        g.drawString("俄罗斯方块", GamePanel.BLOCK_SIZE, GamePanel.HEIGHT - GamePanel.BLOCK_SIZE * 5);
        cursor.Render(g);

    }
    private TextView[] textViews;
    @Override
    public void OnEnter() {
    }

    @Override
    public void OnExit() {
    }

}
