package model.block;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class JBlock extends ShapeBlock {

    private static final Color COLOR = Color.BLUE;
    private State state;

    enum State {
        UP, DOWN, LEFT, RIGHT
    }

    public JBlock(ArrayList<Block> blocks) {
        super(blocks);
        state = State.RIGHT;
    }

    public static JBlock spawnJBlock() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(SPAWNING_ROW, 5, COLOR));
        for (int i = 5; i < 8; i++) {
            blocks.add(new Block(SPAWNING_ROW+1, i, COLOR));
        }
        return new JBlock(blocks);
    }

    @Override
    public ArrayList<Block> rotatingBlocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        int pivotRow = getBlocks().get(2).getRow();
        int pivotCol = getBlocks().get(2).getCol();
        switch (state) {
        case RIGHT:
            blocks.add(new Block(pivotRow+1, pivotCol-1, COLOR));
            blocks.add(new Block(pivotRow + 1, pivotCol, COLOR));
            blocks.add(new Block(pivotRow - 1, pivotCol, COLOR));
            break;
        case UP:
            blocks.add(new Block(pivotRow + 1, pivotCol+1, COLOR));
            blocks.add(new Block(pivotRow, pivotCol+1, COLOR));
            blocks.add(new Block(pivotRow, pivotCol-1, COLOR));
            break;
        case LEFT:
            blocks.add(new Block(pivotRow-1, pivotCol+1, COLOR));
            blocks.add(new Block(pivotRow-1, pivotCol, COLOR));
            blocks.add(new Block(pivotRow+1, pivotCol, COLOR));
            break;
        case DOWN:
            blocks.add(new Block(pivotRow-1, pivotCol-1, COLOR));
            blocks.add(new Block(pivotRow, pivotCol-1, COLOR));
            blocks.add(new Block(pivotRow, pivotCol+1, COLOR));
            break;
        default:
            break;
        }
        return blocks;
    }

    @Override
    public void rotate() {
        ArrayList<Block> blocks = getBlocks();
        int pivotRow = blocks.get(2).getRow();
        int pivotCol = blocks.get(2).getCol();
        switch (state) {
        case RIGHT:
            blocks.get(0).setPos(pivotRow+1, pivotCol-1);
            blocks.get(1).setPos(pivotRow +1, pivotCol);
            blocks.get(3).setPos(pivotRow - 1, pivotCol);
            state = State.UP;
            break;
        case UP:
            blocks.get(0).setPos(pivotRow+1, pivotCol+1);
            blocks.get(1).setPos(pivotRow, pivotCol+1);
            blocks.get(3).setPos(pivotRow, pivotCol-1);
            state = State.LEFT;
            break;
        case LEFT:
            blocks.get(0).setPos(pivotRow-1, pivotCol+1);
            blocks.get(1).setPos(pivotRow-1, pivotCol);
            blocks.get(3).setPos(pivotRow+1, pivotCol);
            state = State.DOWN;
            break;
        case DOWN:
            blocks.get(0).setPos(pivotRow-1, pivotCol-1);
            blocks.get(1).setPos(pivotRow, pivotCol-1);
            blocks.get(3).setPos(pivotRow, pivotCol+1);
            state = State.RIGHT;
            break;
        default:
            break;
        }
    }


}
