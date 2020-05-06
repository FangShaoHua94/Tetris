package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import model.Board;
import model.Game;
import model.MainBoard;
import model.NextBlockBoard;
import model.SideBoard;
import model.block.Block;

import static java.util.Objects.requireNonNull;
import static model.Board.SIZE;
import static model.MainBoard.COL;
import static model.MainBoard.ROW;
import static model.SideBoard.SIDE_BOARD_SIZE;
import static model.block.Block.BORDER_COLOR;


public class Painter {

    public static void paint(Game game, GraphicsContext gc) {
        requireNonNull(game);
        requireNonNull(gc);
        paintMainBoard(game.getMainBoard(), gc);
        paintSideBoard(game.getSideBoard(), gc, Color.WHITE);
    }

    private static void paintMainBoard(MainBoard mainBoard, GraphicsContext gc) {
        requireNonNull(mainBoard);
        gc.setFill(Color.BLACK);
        gc.fillRect(mainBoard.getStartingX(), mainBoard.getStartingY(),
                mainBoard.getCol() * SIZE, mainBoard.getRow() * SIZE);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Block block = mainBoard.getMainBoard()[i][j];
                if (block != null) {
                    paintBlock(block, gc,mainBoard.getStartingX(),mainBoard.getStartingY());
                }
            }
        }
    }

    private static void paintSideBoard(SideBoard sideBoard, GraphicsContext gc, Color color) {
        requireNonNull(sideBoard);
        gc.setFill(color);
        gc.fillRect(sideBoard.getStartingX(), sideBoard.getStartingY(),
                sideBoard.getCol() * SIDE_BOARD_SIZE, sideBoard.getRow() * SIDE_BOARD_SIZE);
        paintNextBlockBoard(sideBoard.getNextBlockBoard(),gc);
    }

    private static void paintNextBlockBoard(NextBlockBoard nextBlockBoard, GraphicsContext gc){
        nextBlockBoard.getNextBlock().getBlocks().forEach(block->
                paintBlock(block,gc,nextBlockBoard.getStartingX(),nextBlockBoard.getStartingY()));
    }

    public static void paintBlock(Block block, GraphicsContext gc, double startingX, double startingY) {
        if (block == null) {
            return;
        }
        gc.setFill(block.getColor());
        gc.fillRect(block.getCol() * SIZE+startingX, block.getRow() * SIZE+startingY, SIZE, SIZE);
        gc.setFill(BORDER_COLOR);
        gc.fillRect(block.getCol() * SIZE+startingX, block.getRow() * SIZE+startingY, SIZE, 2);
        gc.fillRect(block.getCol() * SIZE+startingX, block.getRow() * SIZE + SIZE+startingY, SIZE, 2);
        gc.fillRect(block.getCol() * SIZE+startingX, block.getRow() * SIZE+startingY, 2, SIZE);
        gc.fillRect(block.getCol() * SIZE + SIZE+startingX, block.getRow() * SIZE+startingY, 2, SIZE);
    }


}
