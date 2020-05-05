package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import model.Board;
import model.Game;
import model.MainBoard;
import model.block.Block;

import static java.util.Objects.requireNonNull;
import static model.Board.SIZE;
import static model.MainBoard.COL;
import static model.MainBoard.ROW;
import static model.block.Block.BORDER_COLOR;


public class Painter {

    public static void paint(Game game, GraphicsContext gc) {
        requireNonNull(game);
        requireNonNull(gc);
        paintMainBoard(game.getMainBoard(), gc);
        paintSideBoard(game.getSideBoard(), gc, Color.BROWN);
    }

    private static void paintMainBoard(MainBoard board, GraphicsContext gc) {
        requireNonNull(board);
        gc.setFill(Color.BLACK);
        gc.fillRect(board.getStartingX(), board.getStartingY(), board.getCol() * SIZE, board.getRow() * SIZE);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Block block = board.getMainBoard()[i][j];
                if (block != null) {
                    paintBlock(block, gc);
                }
            }
        }
    }

    private static void paintSideBoard(Board board, GraphicsContext gc, Color color) {
        requireNonNull(board);
        gc.setFill(color);
        gc.fillRect(board.getStartingX(), board.getStartingY(), board.getCol() * SIZE, board.getRow() * SIZE);
    }

    public static void paintBlock(Block block, GraphicsContext gc) {
        if (block == null) {
            return;
        }
        gc.setFill(block.getColor());
        gc.fillRect(block.getCol() * SIZE, block.getRow() * SIZE, SIZE, SIZE);
        gc.setFill(BORDER_COLOR);
        gc.fillRect(block.getCol() * SIZE, block.getRow() * SIZE, SIZE, 2);
        gc.fillRect(block.getCol() * SIZE, block.getRow() * SIZE + SIZE, SIZE, 2);
        gc.fillRect(block.getCol() * SIZE, block.getRow() * SIZE, 2, SIZE);
        gc.fillRect(block.getCol() * SIZE + SIZE, block.getRow() * SIZE, 2, SIZE);
    }


}
