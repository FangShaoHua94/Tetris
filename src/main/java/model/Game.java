package model;

import gui.Painter;
import javafx.scene.canvas.GraphicsContext;
import model.block.Block;
import model.block.ShapeBlock;

import java.util.concurrent.TimeUnit;

import static model.MainBoard.COL;
import static model.MainBoard.ROW;
import static model.block.IBlock.spawnIBlock;
import static model.block.JBlock.spawnJBlock;
import static model.block.LBlock.spawnLBlock;

public class Game implements Runnable {

    private static final long DELAY = 200;

    private final GraphicsContext gc;
    private final MainBoard mainBoard;
    private final Board sideBoard;
    private ShapeBlock currentBlock;

    public Game(GraphicsContext gc) {
        this.gc = gc;
        mainBoard = new MainBoard();
        sideBoard = new SideBoard();
        generateBlock();
    }

    public MainBoard getMainBoard() {
        return mainBoard;
    }

    public Board getSideBoard() {
        return sideBoard;
    }

    public ShapeBlock getCurrentBlock() {
        return currentBlock;
    }

    public void generateBlock() {
        currentBlock = spawnLBlock();
        mainBoard.addNewBlock(currentBlock);
    }

    @Override
    public void run() {
        while (true) {
            Painter.paint(this, gc);
            if (!fall()) {
                if (mainBoard.clearLines()) {
                    Painter.paint(this, gc);
                }
                generateBlock();
            }
            delay();
        }
    }

    public boolean fall() {
        if (currentBlock.getBlocks().stream().allMatch(this::isValidDownMove)) {
            currentBlock.getBlocks().forEach(Block::moveDown);
            mainBoard.update();
            return true;
        }
        return false;
    }

    private boolean notOutOfBound(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL;
    }

    public boolean isValidRightMove(Block block) {
        return notOutOfBound(block.getRow(), block.getCol() + 1)
                && mainBoard.validMove(block.getRow(), block.getCol() + 1);
    }

    public boolean isValidLeftMove(Block block) {
        return notOutOfBound(block.getRow(), block.getCol() - 1)
                && mainBoard.validMove(block.getRow(), block.getCol() - 1);
    }

    public boolean isValidDownMove(Block block) {
        return notOutOfBound(block.getRow() + 1, block.getCol())
                && mainBoard.validMove(block.getRow() + 1, block.getCol());
    }

    public boolean isValidRotate(int row, int col) {
        return notOutOfBound(row, col) && mainBoard.validMove(row, col);
    }

    private void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(DELAY);
        } catch (InterruptedException ie) {
            //suppress
        }
    }
}
