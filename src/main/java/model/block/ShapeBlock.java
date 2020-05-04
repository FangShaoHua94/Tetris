package model.block;

import java.util.ArrayList;

import static model.Game.isValidDownMove;

public abstract class ShapeBlock implements Fallible,Rotatable{

    public static final int SPAWNING_ROW=0;
    ArrayList<Block> blocks;

    public ShapeBlock(ArrayList<Block> blocks) {
        this.blocks=blocks;
    }

    public ArrayList<Block> getBlocks(){
        return blocks;
    }

    public void fall(){
       if(blocks.stream().allMatch(block-> isValidDownMove(block))) {
           blocks.forEach(block -> block.moveDown());
       }
    }
}
