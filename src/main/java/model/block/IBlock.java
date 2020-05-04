package model.block;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class IBlock extends ShapeBlock{

    private static final Color COLOR=Color.SKYBLUE;
    private State state;

    enum State{
        HORIZONTAL,VERTICAL
    }

    public IBlock(ArrayList<Block> blocks) {
        super(blocks);
        state=State.HORIZONTAL;
    }

    public static IBlock spawnIBlock(){
        ArrayList<Block> blocks=new ArrayList<>();
        for(int i=3;i<7;i++){
            blocks.add(new Block(i,SPAWNING_ROW,COLOR));
        }
        return new IBlock(blocks);
    }

    @Override
    public void rotate(){
        ArrayList<Block> blocks= getBlocks();
        ArrayList<Block> newBlocks=new ArrayList<>();
        Block pivotBlock= blocks.get(2);
        switch (state){
        case HORIZONTAL:
            blocks.set(1,pivotBlock.duplicateBlockBelow());
            blocks.set(3,pivotBlock.duplicateBlockAbove());
            blocks.set(4,pivotBlock.duplicateBlockAbove().duplicateBlockAbove());
            state=State.VERTICAL;
            break;
        case VERTICAL:
            blocks.set(1,pivotBlock.duplicateBlockOnLeft());
            blocks.set(3,pivotBlock.duplicateBlockOnRight());
            blocks.set(4,pivotBlock.duplicateBlockOnRight().duplicateBlockOnRight());
            state=State.HORIZONTAL;
            break;
        default:
            break;
        }
    }

}
