package model;

import gui.KeyHandler;
import gui.Painter;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.block.ShapeBlock;

import java.util.concurrent.TimeUnit;

public class Game implements Runnable{

    private final GraphicsContext gc;
    private final Board mainBoard;
    private final Board sideBoard;
    private Canvas canvas;
    private ShapeBlock currentBlock;

    public Game(GraphicsContext gc, Canvas canvas){
        this.gc=gc;
        this.canvas=canvas;
        mainBoard = new MainBoard();
        sideBoard = new SideBoard();
        currentBlock= mainBoard.getCurrentBlock();
        canvas.setOnKeyPressed(new KeyHandler(currentBlock));
    }

    public Board getMainBoard(){
        return mainBoard;
    }

    public Board getSideBoard(){
        return sideBoard;
    }

    @Override
    public void run() {
        while (true) {
            Painter.paint(this, gc);
            System.out.println("continue...");
            delay(100);
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
