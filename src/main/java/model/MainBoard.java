package model;

import model.block.Block;
import model.block.ShapeBlock;

public class MainBoard extends Board{

    public static final int ROW = 24;
    public static final int COL = 14;
    private static final double STARTING_X=0;
    private static final double STARTING_Y=0;
    private Block[][] mainBoard;

    public MainBoard(){
        super(ROW, COL,STARTING_X,STARTING_Y);
        mainBoard=new Block[ROW][COL];
    }

    public void addNewBlock(ShapeBlock newBlock){
        newBlock.getBlocks().forEach(block -> mainBoard[block.getRow()][block.getCol()]=block);
    }

    public Block[][] getMainBoard(){
        return mainBoard;
    }



}
