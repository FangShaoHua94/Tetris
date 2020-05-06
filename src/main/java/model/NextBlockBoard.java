package model;

import model.block.ShapeBlock;

import static model.block.ShapeBlock.spawnBlock;

public class NextBlockBoard extends Board {

    private static final int SEED = 1;
    private static final double STARTING_X = 250;
    private static final double STARTING_Y = 250;
    private ShapeBlock nextBlock;

    public NextBlockBoard() {
        super(STARTING_X, STARTING_Y);
        nextBlock = spawnBlock(SEED);
    }

    public ShapeBlock getNextBlock() {
        return nextBlock;
    }

    public void spawnNextBlock() {
        nextBlock = spawnBlock(SEED);
    }


}
