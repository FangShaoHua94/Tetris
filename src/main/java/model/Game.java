package model;

import gui.KeyHandler;
import gui.Painter;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.block.ShapeBlock;

import java.util.concurrent.TimeUnit;

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

    private void delay(long delayTime) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException ie) {
            //suppress
        }
    }
}
