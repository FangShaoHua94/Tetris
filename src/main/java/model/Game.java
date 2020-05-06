package model;

import gui.Painter;
import javafx.scene.canvas.GraphicsContext;
import model.block.Block;
import model.block.ShapeBlock;
import storage.StorageManager;

import java.util.concurrent.TimeUnit;

import static model.MainBoard.COL;
import static model.MainBoard.ROW;
import static model.block.ShapeBlock.spawnBlock;

public class Game implements Runnable {

    private static final long FALL_DELAY = 200;
    private static final long END_GAME_DELAY = 50;
    private static final int LINE_SCORE = 100;
    private static final int SEED = 3;

    private final GraphicsContext gc;
    private final MainBoard mainBoard;
    private final SideBoard sideBoard;
    private StorageManager storageManager;
    private ShapeBlock currentBlock;
    private boolean isPause;
    private boolean isTerminate;

    public Game(GraphicsContext gc) {
        this.gc = gc;
        storageManager = new StorageManager();
        mainBoard = new MainBoard();
        sideBoard = new SideBoard(storageManager.load());
        currentBlock = spawnBlock(SEED);
        mainBoard.addNewBlock(currentBlock);
        isPause = false;
        isTerminate = false;
    }

    public MainBoard getMainBoard() {
        return mainBoard;
    }

    public SideBoard getSideBoard() {
        return sideBoard;
    }

    public ShapeBlock getCurrentBlock() {
        return currentBlock;
    }

    public boolean isPaused() {
        return isPause;
    }

    @Override
    public void run() {
        boolean endGame = false;
        while (!endGame) {
            while (!isPause) {
                if (isTerminated()) {
                    return;
                }
                Painter.paint(this, gc);
                if (!fall()) {
                    if (mainBoard.clearLines()) {
                        sideBoard.getScoreBoard().AddScore(mainBoard.getLineCleared() * LINE_SCORE);
                        Painter.paint(this, gc);
                    }
                    currentBlock = sideBoard.getNextBlockBoard().getNextBlock();
                    sideBoard.getNextBlockBoard().spawnNextBlock();
                    if (!mainBoard.addNewBlock(currentBlock)) {
                        endGame = true;
                        break;
                    }
                }
                delay(FALL_DELAY);
            }
            delay(FALL_DELAY);
        }
        storageManager.save(sideBoard.getScoreBoard().getHighScore());
        endGameEffect();
    }

    public void pause() {
        isPause = true;
    }

    public void unpause() {
        isPause = false;
    }

    public void terminateGame() {
        isTerminate = true;
    }

    private boolean isTerminated() {
        return isTerminate;
    }

    public void endGameEffect() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (isTerminate) {
                    return;
                }
                mainBoard.addNewBlock(new Block(i, j, currentBlock.getBlocks().get(0).getColor()));
                Painter.paint(this, gc);
                delay(END_GAME_DELAY);
            }
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

    public static void delay(long delayTime) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException ie) {
            //suppress
        }
    }
}
