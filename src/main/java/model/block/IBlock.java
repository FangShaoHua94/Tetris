package model.block;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class IBlock extends ShapeBlock {

    private static final Color COLOR = Color.SKYBLUE;
    private State state;

    enum State {
        HORIZONTAL, VERTICAL
    }

    public IBlock(ArrayList<Block> blocks) {
        super(blocks);
        state = State.HORIZONTAL;
    }

    public static IBlock spawnIBlock() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 4; i < 8; i++) {
            blocks.add(new Block(SPAWNING_ROW, i, COLOR));
        }
        return new IBlock(blocks);
    }

    @Override
    public ArrayList<Block> rotatingBlocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        int pivotRow = getBlocks().get(1).getRow();
        int pivotCol = getBlocks().get(1).getCol();
        switch (state) {
        case HORIZONTAL:
            blocks.add(new Block(pivotRow + 1, pivotCol, COLOR));
            blocks.add(new Block(pivotRow - 1, pivotCol, COLOR));
            blocks.add(new Block(pivotRow - 2, pivotCol, COLOR));
            break;
        case VERTICAL:
            blocks.add(new Block(pivotRow, pivotCol - 1, COLOR));
            blocks.add(new Block(pivotRow, pivotCol + 1, COLOR));
            blocks.add(new Block(pivotRow, pivotCol + 2, COLOR));
            break;
        default:
            break;
        }
        return blocks;
    }

    @Override
    public void rotate() {
        ArrayList<Block> blocks = getBlocks();
        int pivotRow = blocks.get(1).getRow();
        int pivotCol = blocks.get(1).getCol();
        switch (state) {
        case HORIZONTAL:
            blocks.get(0).setPos(pivotRow + 1, pivotCol);
            blocks.get(2).setPos(pivotRow - 1, pivotCol);
            blocks.get(3).setPos(pivotRow - 2, pivotCol);

            state = State.VERTICAL;
            break;
        case VERTICAL:
            blocks.get(0).setPos(pivotRow, pivotCol - 1);
            blocks.get(2).setPos(pivotRow, pivotCol + 1);
            blocks.get(3).setPos(pivotRow, pivotCol + 2);

            state = State.HORIZONTAL;
            break;
        default:
            break;
        }
    }

}
