package model;

import javafx.scene.canvas.GraphicsContext;

public class Game implements Runnable{

    private final GraphicsContext gc;
    private final Board board;

    public Game(GraphicsContext gc){
        this.gc=gc;
        board=new Board();
    }

    @Override
    public void run() {

    }
}
