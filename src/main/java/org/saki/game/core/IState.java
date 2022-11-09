package org.saki.game.core;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface IState {
    void Update();
    void Render(Graphics g);
    void OnEnter();
    void OnExit();

}
