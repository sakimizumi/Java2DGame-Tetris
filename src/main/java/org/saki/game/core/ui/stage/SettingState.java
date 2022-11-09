package org.saki.game.core.ui.stage;

import org.saki.game.core.GameConst;
import org.saki.game.core.IState;
import org.saki.game.core.StateMachine;
import org.saki.game.core.ui.GamePanel;
import org.saki.game.core.ui.widget.CursorView;
import org.saki.game.core.ui.widget.ListItemView;

import java.awt.*;
import java.util.Set;

public class SettingState implements IState {
    private final StateMachine stateMachine;
    private CursorView cursorView;
    private ListItemView[] itemViews = new ListItemView[4];
    private boolean objectLock = false;
    private int index = 0;

    public SettingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        cursorView = new CursorView();
        int width = GamePanel.WIDTH - GamePanel.BLOCK_SIZE * 3;
        itemViews[0] = new ListItemView("GO LEFT","A",width);
        itemViews[1] = new ListItemView("GO RIGHT","D",width);
        itemViews[2] = new ListItemView("GO DOWN", String.valueOf((char)GameConst.KEY_DOWN) ,width);
        itemViews[3] = new ListItemView("ROTATE", String.valueOf((char)GameConst.KEY_UP) ,width);
        itemViews[0].setPos(GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE * 2);
        itemViews[1].setPos(GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE * 3);
        itemViews[2].setPos(GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE * 4);
        itemViews[3].setPos(GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE * 5);
    }

    @Override
    public void Update() {

        if(!objectLock){
            if(stateMachine.keyHandler.isPRESS_BACK()){
                stateMachine.Change("MENU");
            }else if(stateMachine.keyHandler.isPRESS_OK()){
                objectLock = true;
            }else if(stateMachine.keyHandler.isPRESS_DOWN()){
                index++;
            }else if(stateMachine.keyHandler.isPRESS_UP()){
                index--;
            }
            indexLimit();
            cursorView.setLocation(itemViews[index]);
        }else{
            itemViews[index].selected(cursorView);
            if(stateMachine.keyHandler.isPRESS_BACK()){
                objectLock = false;
            }

        }
    }

    private void indexLimit() {
        if(index >= itemViews.length - 1){
            index = itemViews.length -1;
        }
        if(index <= 0){
            index = 0;
        }
    }

    @Override
    public void Render(Graphics g) {
        for (ListItemView itemView : itemViews){
            itemView.Render(g);
        }
        cursorView.Render(g);
    }

    @Override
    public void OnEnter() {

    }

    @Override
    public void OnExit() {

    }
}
