package model;

import model.block.ShapeBlock;

public class SideBoard extends Board{

    private static final int ROW = 24;
    private static final int COL = 6;
    private static final double STARTING_X=350;
    private static final double STARTING_Y=0;

    public SideBoard(){
        super(ROW, COL,STARTING_X,STARTING_Y);
    }

    @Override
    public ShapeBlock getCurrentBlock() {
        return null;
    }
}
