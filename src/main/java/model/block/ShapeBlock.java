package model.block;

import java.util.ArrayList;

public abstract class ShapeBlock implements Rotatable{

    public static final int SPAWNING_ROW=0;
    ArrayList<Block> blocks;

    public ShapeBlock(ArrayList<Block> blocks) {
        this.blocks=blocks;
    }

    public ArrayList<Block> getBlocks(){
        return blocks;
    }

}
