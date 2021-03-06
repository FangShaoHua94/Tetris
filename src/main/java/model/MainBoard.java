package model;

import model.block.Block;
import model.block.ShapeBlock;

import java.util.ArrayList;

public class MainBoard extends Board {

    public static final int ROW = 24;
    public static final int COL = 12;
    private static final double STARTING_X = 0;
    private static final double STARTING_Y = 0;
    private ShapeBlock currentBlock;
    private Block[][] mainBoard;
    private int lineCleared;

    public MainBoard() {
        super(ROW, COL, STARTING_X, STARTING_Y);
        mainBoard = new Block[ROW][COL];
        lineCleared = 0;
    }

    public boolean addNewBlock(ShapeBlock newBlock) {
        currentBlock = newBlock;
        for (int i = 0; i < newBlock.getBlocks().size(); i++) {
            int row = newBlock.getBlocks().get(i).getRow();
            int col = newBlock.getBlocks().get(i).getCol();
            if (mainBoard[row][col] != null) {
                return false;
            } else {
                mainBoard[row][col] = newBlock.getBlocks().get(i);
            }
        }
        return true;
    }

    public void addNewBlock(Block block) {
        mainBoard[block.getRow()][block.getCol()] = block;
    }

    public void update() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (mainBoard[i][j] != null) {
                    blocks.add(mainBoard[i][j]);
                }
            }
        }
        mainBoard = new Block[ROW][COL];
        blocks.forEach(block -> mainBoard[block.getRow()][block.getCol()] = block);
    }

    public Block[][] getMainBoard() {
        return mainBoard;
    }

    public boolean validMove(int row, int col) {
        return mainBoard[row][col] == null
                || currentBlock.getBlocks().stream().anyMatch(block -> block.equals(mainBoard[row][col]));
    }

    public int getLineCleared() {
        return lineCleared;
    }

    public boolean clearLines() {
        boolean clearLine = false;
        lineCleared = 0;
        for (int i = 0; i < ROW; i++) {
            if (checkLineClear(i)) {
                clearLine(i);
                shiftDown(i);
                lineCleared++;
                clearLine = true;
            }
        }
        return clearLine;
    }

    private boolean checkLineClear(int row) {
        for (int j = 0; j < COL; j++) {
            if (mainBoard[row][j] == null) {
                return false;
            }
        }
        return true;
    }

    private void clearLine(int row) {
        for (int j = 0; j < COL; j++) {
            mainBoard[row][j] = null;
        }
    }

    private void shiftDown(int row) {
        for (int m = row; m > 0; m--) {
            for (int n = 0; n < COL; n++) {
                if (mainBoard[m - 1][n] != null) {
                    mainBoard[m][n] = mainBoard[m - 1][n];
                    mainBoard[m][n].setRow(m);
                    mainBoard[m - 1][n] = null;
                }
            }
        }
    }


}
