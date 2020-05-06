package model.block;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class OBlock extends ShapeBlock {

    private static final Color COLOR = Color.YELLOW;

    public OBlock(ArrayList<Block> blocks) {
        super(blocks);
    }

    public static OBlock spawnOBlock() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = SPAWNING_ROW; i < SPAWNING_ROW + 2; i++) {
            for (int j = 5; j < 7; j++) {
                blocks.add(new Block(i, j, COLOR));
            }
        }
        return new OBlock(blocks);
    }

    @Override
    public ArrayList<Block> rotatingBlocks() {
        return new ArrayList<>();
    }

    @Override
    public void rotate() {
    }
}
