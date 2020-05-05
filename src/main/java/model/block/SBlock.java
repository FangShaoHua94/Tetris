package model.block;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SBlock extends ShapeBlock{

    private static final Color COLOR = Color.GREEN;
    private State state;

    enum State {
        HORIZONTAL, VERTICAL
    }

    public SBlock(ArrayList<Block> blocks) {
        super(blocks);
        state = State.HORIZONTAL;
    }

    public static SBlock spawnSBlock() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(SPAWNING_ROW, 6, COLOR));
        blocks.add(new Block(SPAWNING_ROW, 7, COLOR));
        blocks.add(new Block(SPAWNING_ROW+1, 5, COLOR));
        blocks.add(new Block(SPAWNING_ROW+1, 6, COLOR));
        return new SBlock(blocks);
    }

    @Override
    public ArrayList<Block> rotatingBlocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        int pivotRow = getBlocks().get(0).getRow();
        int pivotCol = getBlocks().get(0).getCol();
        switch (state) {
        case HORIZONTAL:
            blocks.add(new Block(pivotRow - 1, pivotCol, COLOR));
            blocks.add(new Block(pivotRow + 1, pivotCol+1, COLOR));
            blocks.add(new Block(pivotRow , pivotCol+1, COLOR));
            break;
        case VERTICAL:
            blocks.add(new Block(pivotRow, pivotCol + 1, COLOR));
            blocks.add(new Block(pivotRow+1, pivotCol - 1, COLOR));
            blocks.add(new Block(pivotRow+1, pivotCol, COLOR));
            break;
        default:
            break;
        }
        return blocks;
    }

    @Override
    public void rotate() {
        ArrayList<Block> blocks = getBlocks();
        int pivotRow = blocks.get(0).getRow();
        int pivotCol = blocks.get(0).getCol();
        switch (state) {
        case HORIZONTAL:
            blocks.get(1).setPos(pivotRow - 1, pivotCol);
            blocks.get(2).setPos(pivotRow + 1, pivotCol+1);
            blocks.get(3).setPos(pivotRow, pivotCol+1);
            state = State.VERTICAL;
            break;
        case VERTICAL:
            blocks.get(1).setPos(pivotRow, pivotCol + 1);
            blocks.get(2).setPos(pivotRow+1, pivotCol -1);
            blocks.get(3).setPos(pivotRow+1, pivotCol);
            state = State.HORIZONTAL;
            break;
        default:
            break;
        }
    }


}
