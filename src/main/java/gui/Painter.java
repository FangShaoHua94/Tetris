package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import model.Board;
import model.Game;

import static java.util.Objects.requireNonNull;



public class Painter {

    private static final String SCORE_TEXT = "Score : %d";
    private static final String LEVEL_TEXT = "Level : %d";

    /**
     * Paints the board with game details.
     *
     * @param game contains detail of the game.
     * @param gc   is the scene to be painted on.
     */
    public static void paint(Game game, GraphicsContext gc) {
        requireNonNull(game);
        requireNonNull(gc);
//        paintBoard(game.getBoard(), gc);

    }

    private static void paintBoard(Board board, GraphicsContext gc) {
        requireNonNull(board);
        gc.setFill(Color.BLACK);
//        gc.fillRect(0, 0, board.getWidth() * SIZE, board.getHeight() * SIZE);
    }

}
