package gui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.block.Block;
import model.block.ShapeBlock;

import java.util.ArrayList;


public class KeyHandler implements EventHandler<KeyEvent> {

    private ShapeBlock currentBlock;

    public KeyHandler(ShapeBlock currentBlock){
        this.currentBlock=currentBlock;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        ArrayList<Block> blocks=currentBlock.getBlocks();
        switch (keyEvent.getCode()) {
        case UP:
            if(blocks.stream().allMatch(block-> block.isValidUpMove())) {
                blocks.forEach(block -> block.moveUp());
            }
//            blocks.forEach(block -> block.moveUp());
            System.out.println("up");
            break;
        case DOWN:
            if(blocks.stream().allMatch(block-> block.isValidDownMove())) {
                blocks.forEach(block -> block.moveDown());
            }
            System.out.println("down");
            break;
        case LEFT:
            if(blocks.stream().allMatch(block-> block.isValidLeftMove())) {
                blocks.forEach(block -> block.moveLeft());
            }
            System.out.println("left");
            break;
        case RIGHT:
            if(blocks.stream().allMatch(block-> block.isValidRightMove())) {
                blocks.forEach(block -> block.moveRight());
            }
            System.out.println("right");
            break;
        case SPACE:
            currentBlock.rotate();
            System.out.println("rotate");
        default:
            break;
        }
    }
}
