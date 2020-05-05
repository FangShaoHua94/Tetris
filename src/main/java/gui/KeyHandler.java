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

    public KeyHandler(Game game, GraphicsContext gc){
        this.game=game;
        this.gc=gc;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        ShapeBlock currentBlock = game.getCurrentBlock();
        ArrayList<Block> blocks=currentBlock.getBlocks();
        switch (keyEvent.getCode()) {
        case UP:
            if(blocks.stream().allMatch(block-> game.isValidUpMove(block))) {
                blocks.forEach(Block::moveUp);
                game.getMainBoard().update();
            }
            System.out.println("up");
            break;
        case DOWN:
            if(blocks.stream().allMatch(block-> game.isValidDownMove(block))) {
                blocks.forEach(Block::moveDown);
                game.getMainBoard().update();
            }
            System.out.println("down");
            break;
        case LEFT:
            if(blocks.stream().allMatch(block-> game.isValidLeftMove(block))) {
                blocks.forEach(Block::moveLeft);
                game.getMainBoard().update();
            }
            System.out.println("left");
            break;
        case RIGHT:
            if(blocks.stream().allMatch(block-> game.isValidRightMove(block))) {
                blocks.forEach(Block::moveRight);
                game.getMainBoard().update();
            }
            System.out.println("right");
            break;
        case SPACE:
            currentBlock.rotate();
            game.getMainBoard().update();
            System.out.println("rotate");
        default:
            break;
        }
        Painter.paint(game,gc);
    }
}
