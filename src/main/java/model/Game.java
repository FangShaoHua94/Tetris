package model;

import gui.KeyHandler;
import gui.Painter;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.block.Block;
import model.block.ShapeBlock;

import java.util.concurrent.TimeUnit;

import static model.MainBoard.COL;
import static model.MainBoard.ROW;
import static model.block.IBlock.spawnIBlock;

public class Game implements Runnable{

    private final GraphicsContext gc;
    private final MainBoard mainBoard;
    private final Board sideBoard;
    private Canvas canvas;
    private ShapeBlock currentBlock;

    public Game(GraphicsContext gc, Canvas canvas){
        this.gc=gc;
        this.canvas=canvas;
        mainBoard = new MainBoard();
        sideBoard = new SideBoard();
        generateBlock();
    }

    public MainBoard getMainBoard(){
        return mainBoard;
    }

    public Board getSideBoard(){
        return sideBoard;
    }

    public void generateBlock(){
        currentBlock=spawnIBlock();
        mainBoard.addNewBlock(currentBlock);
        canvas.setOnKeyPressed(new KeyHandler(currentBlock));
    }

    @Override
    public void run() {
        while (true) {
            Painter.paint(this, gc);
            currentBlock.fall();
            System.out.println("continue...");
            delay(500);
        }
    }

    public static boolean notOutOfBound(int row, int col){
        return row >= 0 && row < ROW && col >= 0 && col < COL;
    }

    public static boolean isValidRightMove(Block block){
        return notOutOfBound(block.getRow(), block.getCol() + 1);
    }

    public static boolean isValidLeftMove(Block block){
        return notOutOfBound(block.getRow(), block.getCol() - 1);
    }

    public static boolean isValidDownMove(Block block){
        return notOutOfBound(block.getRow() + 1, block.getCol());
    }

    public static boolean isValidUpMove(Block block){
        return notOutOfBound(block.getRow() - 1, block.getCol());
    }

    private void delay(long delayTime) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException ie) {
            //suppress
        }
    }
}
