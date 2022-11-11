package org.saki.game.core.ui;

import org.saki.game.core.GameConst;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean PRESS_UP = false;
    private boolean PRESS_DOWN = false;
    private boolean PRESS_LEFT = false;
    private boolean PRESS_RIGHT = false;
    private boolean PRESS_OK = false;

    private boolean PRESS_BACK = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code){
            case GameConst.KEY_UP -> PRESS_UP = true;
            case GameConst.KEY_DOWN -> PRESS_DOWN = true;
            case GameConst.KEY_LEFT -> PRESS_LEFT = true;
            case GameConst.KEY_RIGHT -> PRESS_RIGHT = true;
            case GameConst.KEY_OK -> PRESS_OK = true;
            case GameConst.KEY_BACK -> PRESS_BACK = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code){
            case GameConst.KEY_UP -> PRESS_UP = false;
            case GameConst.KEY_DOWN -> PRESS_DOWN = false;
            case GameConst.KEY_LEFT -> PRESS_LEFT = false;
            case GameConst.KEY_RIGHT -> PRESS_RIGHT = false;
            case GameConst.KEY_OK -> PRESS_OK = false;
            case GameConst.KEY_BACK -> PRESS_BACK = false;
        }
    }

    public boolean isPRESS_UP() {
        boolean temp = PRESS_UP;
        PRESS_UP = false;
        return temp;
    }

    public boolean isPRESS_DOWN() {
        boolean temp = PRESS_DOWN;
        PRESS_DOWN = false;
        return temp;
    }
    public boolean isPRESS_LEFT() {
        boolean temp = PRESS_LEFT;
        PRESS_LEFT = false;
        return temp;
    }
    public boolean isPRESS_RIGHT() {
        boolean temp = PRESS_RIGHT;
        PRESS_RIGHT = false;
        return temp;
    }
    public boolean isPRESS_OK() {
        boolean temp = PRESS_OK;
        PRESS_OK = false;
        return temp;
    }
    public boolean isPRESS_BACK() {
        boolean temp = PRESS_BACK;
        PRESS_BACK = false;
        return temp;
    }
}
