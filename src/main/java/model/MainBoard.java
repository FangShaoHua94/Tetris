package model;

import model.block.Block;
import model.block.ShapeBlock;

import static model.block.IBlock.spawnIBlock;

import java.util.ArrayList;

public class MainBoard extends Board{

    public static final int ROW = 24;
    public static final int COL = 14;
    private static final double STARTING_X=0;
    private static final double STARTING_Y=0;
    private ArrayList<Block> mainBoard;

    public MainBoard(){
        super(ROW, COL,STARTING_X,STARTING_Y);
        mainBoard = new ArrayList<>();
    }

    public void addNewBlock(ShapeBlock newBlock){
        mainBoard.addAll(newBlock.getBlocks());
    }

    public ArrayList<Block> getMainBoard(){
        return mainBoard;
    }


}
