package org.saki.game.core.entity;

import java.awt.*;

public enum ErsBlock {

    BLOCK_I(new Point(3,0),new Point(3,1),new Point(3,2),new Point(3,3)),
    BLOCK_T(new Point(1,0),new Point(2,0),new Point(3,0),new Point(2,1)),
    BLOCK_O(new Point(3,3),new Point(3,2),new Point(2,3),new Point(2,2)),
    BLOCK_Z1(),
    BLOCK_Z2(),
    BLOCK_L1(),
    BLOCK_L2();
    int[][] style = new int[4][4];

    ErsBlock(Point... value){
        for(Point p : value){
            style[(int) p.getX()][(int) p.getY()] = 1;
        }
    }

}
