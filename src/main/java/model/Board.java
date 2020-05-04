package model;

import model.block.Block;
import model.block.ShapeBlock;

public abstract class Board {

    public static final double SIZE=25;

    private final int row;
    private final int col;
    private final double startingX;
    private final double startingY;


    public Board(int row,int col,double startingX, double startingY) {
        this.row=row;
        this.col=col;
        this.startingX=startingX;
        this.startingY=startingY;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getStartingX() {
        return startingX;
    }

    public double getStartingY() {
        return startingY;
    }

    public abstract ShapeBlock getCurrentBlock();

}
