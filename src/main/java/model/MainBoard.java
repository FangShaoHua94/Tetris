package model;

import model.block.Block;
import model.block.ShapeBlock;

import static model.block.IBlock.spawnIBlock;

import java.util.ArrayList;

public class MainBoard extends Board{

    private static final int ROW = 24;
    private static final int COL = 14;
    private static final double STARTING_X=0;
    private static final double STARTING_Y=0;
    private ArrayList<Block> mainBoard;
    private ShapeBlock currentBlock;

    public MainBoard(){
        super(ROW, COL,STARTING_X,STARTING_Y);
        mainBoard = new ArrayList<>();
        fillBoard();
    }

    private void fillBoard(){
        currentBlock=spawnIBlock();
        mainBoard.addAll(currentBlock.getBlocks());
    }

    public ArrayList<Block> getMainBoard(){
        return mainBoard;
    }

    @Override
    public ShapeBlock getCurrentBlock() {
        return currentBlock;
    }
}
