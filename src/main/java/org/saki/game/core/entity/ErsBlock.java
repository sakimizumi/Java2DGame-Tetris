package org.saki.game.core.entity;

import java.awt.*;

public enum ErsBlock {

    /**
     * [
     * [ (-2,-2), (-2,-2), (0,-2), (1,-2), (2,-2)],
     * [ (-2,-1), (-2,-1), (0,-1), (1,-1), (2,-2)],
     * [ (-2, 0), (-1, 0), (0, 0), (1, 0)  (2, 0)],
     * [ (-2, 1), (-1, 1), (0, 1), (1, 1), (1, 1)],
     * [ (-2, 2), (-1, 2), (0, 2), (1, 1), (1, 1)],
     * ]
     */
    BLOCK_I(true,new Point(0, 0),new Point(0, -1),new Point(0, -2),new Point(0, 1),new Point(0, 2)),
    BLOCK_T(true,new Point(0, 0),new Point(0, 0), new Point(1, 0), new Point(0, -0), new Point(-1, 0)),
    BLOCK_O(false,new Point(0, 0),new Point(0, 0), new Point(0, -1), new Point(1, 0), new Point(1, -1)),
    BLOCK_Z1(true,new Point(0, 0),new Point(0, 0),new Point(0, -1),new Point(1, 0),new Point(1, 1)),
    BLOCK_Z2(true,new Point(0, 0),new Point(0, 0),new Point(0, -1),new Point(-1, 0),new Point(-1, 1)),
    BLOCK_L2(true,new Point(0, 1),new Point(0, 0),new Point(-1, 0),new Point(0, 1),new Point(0, 0));
    int[][] style = new int[5][5];
    Point[] points;
    boolean isRotateAble;
    Point rotatePoint;
    ErsBlock(boolean rotateAble,Point rotatePoint, Point... value) {
        this.isRotateAble = rotateAble;
        this.rotatePoint = rotatePoint;
        this.points = value;
        for (Point p : value) {
            style[(int) p.getX() + 2][(int) p.getY() + 2] = 1;
        }
    }

}
