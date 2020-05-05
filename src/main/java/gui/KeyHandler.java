package gui;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import model.Game;
import model.block.Block;
import model.block.ShapeBlock;

import java.util.ArrayList;

public class KeyHandler implements EventHandler<KeyEvent> {

    private Game game;
    private GraphicsContext gc;

    public KeyHandler(Game game, GraphicsContext gc) {
        this.game = game;
        this.gc = gc;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        ShapeBlock currentBlock = game.getCurrentBlock();
        ArrayList<Block> blocks = currentBlock.getBlocks();
        switch (keyEvent.getCode()) {
        case DOWN:
            if (blocks.stream().allMatch(block -> game.isValidDownMove(block))) {
                blocks.forEach(Block::moveDown);
                game.getMainBoard().update();
            }
            break;
        case LEFT:
            if (blocks.stream().allMatch(block -> game.isValidLeftMove(block))) {
                blocks.forEach(Block::moveLeft);
                game.getMainBoard().update();
            }
            break;
        case RIGHT:
            if (blocks.stream().allMatch(block -> game.isValidRightMove(block))) {
                blocks.forEach(Block::moveRight);
                game.getMainBoard().update();
            }
            break;
        case SPACE:
            if (currentBlock.rotatingBlocks().stream().allMatch(block ->
                    game.isValidRotate(block.getRow(), block.getCol()))) {
                currentBlock.rotate();
                game.getMainBoard().update();
            }
        default:
            break;
        }
        Painter.paint(game, gc);
    }
}
