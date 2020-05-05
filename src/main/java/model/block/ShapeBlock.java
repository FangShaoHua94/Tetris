package model.block;

import java.util.ArrayList;
import java.util.Random;

import static model.block.IBlock.spawnIBlock;
import static model.block.JBlock.spawnJBlock;
import static model.block.LBlock.spawnLBlock;
import static model.block.OBlock.spawnOBlock;
import static model.block.SBlock.spawnSBlock;
import static model.block.TBlock.spawnTBlock;
import static model.block.ZBlock.spawnZBlock;

public abstract class ShapeBlock implements Rotatable {

    public static final int SPAWNING_ROW = 0;
    ArrayList<Block> blocks;

    public ShapeBlock(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static ShapeBlock spawnBlock(){
        Random random = new Random(System.currentTimeMillis());
        switch (random.nextInt(6)){
        case 0:
            return spawnIBlock();
        case 1:
            return spawnJBlock();
        case 2:
            return spawnLBlock();
        case 3:
            return spawnSBlock();
        case 4:
            return spawnTBlock();
        case 5:
            return spawnZBlock();
        default:
            break;
        }
        return spawnOBlock();
    }

}
