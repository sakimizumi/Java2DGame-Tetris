package org.saki.game;

import org.saki.game.core.StateMachine;
import org.saki.game.core.ui.GameWindow;
import org.saki.game.core.ui.resource.ImageResource;

public class Main {
    public static void main(String[] args) {
        ImageResource.getInstance().load();
        GameWindow window = new GameWindow();
        window.init(args);
        window.start();
    }
//    }
}
