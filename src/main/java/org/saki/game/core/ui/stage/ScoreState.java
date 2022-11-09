package org.saki.game.core.ui.stage;

import org.saki.game.core.IState;
import org.saki.game.core.StateMachine;
import org.saki.game.core.ui.widget.ScoreBoard;

import java.awt.*;

public class ScoreState implements IState {
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final StateMachine stateMachine;
    public ScoreState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    @Override
    public void Update() {
        if(stateMachine.keyHandler.isPRESS_BACK()){
            stateMachine.Change("MENU");
        }
    }

    @Override
    public void Render(Graphics g) {
        scoreBoard.Render(g);
    }

    @Override
    public void OnEnter() {
        scoreBoard.load();
    }

    @Override
    public void OnExit() {

    }
}
