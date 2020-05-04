package gui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.block.ShapeBlock;


public class KeyHandler implements EventHandler<KeyEvent> {

    private ShapeBlock currentBlock;

    public KeyHandler(ShapeBlock currentBlock){
        this.currentBlock=currentBlock;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
        case UP:
            currentBlock.getBlocks().forEach(block -> block.moveUp());
            System.out.println("up");
            break;
        case DOWN:
            currentBlock.getBlocks().forEach(block -> block.moveDown());
            System.out.println("down");
            break;
        case LEFT:
            currentBlock.getBlocks().forEach(block -> block.moveLeft());
            System.out.println("left");
            break;
        case RIGHT:
            currentBlock.getBlocks().forEach(block -> block.moveRight());
            System.out.println("right");
            break;
        default:
            break;
        }
    }
}
