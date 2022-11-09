package org.saki.game.core;

import org.saki.game.core.ui.KeyHandler;
import org.saki.game.core.ui.stage.EmptyState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class StateMachine {
    Map<String, IState> mStates = new HashMap<String, IState>();
    IState mCurrentState = new EmptyState();
    public KeyHandler keyHandler = new KeyHandler();
    public void Update()
    {
        mCurrentState.Update();
    }

    public void Render(Graphics g)
    {
        mCurrentState.Render(g);
    }

    public void Change(String stateName)
    {
        mCurrentState.OnExit();
        mCurrentState = mStates.get(stateName);
        mCurrentState.OnEnter();
    }

    public void Add(String name, IState state)
    {
        mStates.put(name, state);
    }


}
