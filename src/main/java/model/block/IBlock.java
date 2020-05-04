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
//        blocks.add(new Block(3,0,Color.RED));
//        blocks.add(new Block(4,0,Color.GREEN));
//        blocks.add(new Block(5,0,Color.ORANGE));
//        blocks.add(new Block(6,0,Color.PURPLE));
        return new IBlock(blocks);
    }

    @Override
    public void rotate(){
        ArrayList<Block> blocks= getBlocks();
        int pivotRow = blocks.get(1).getRow();
        int pivotCol = blocks.get(1).getCol();
        switch (state){
        case HORIZONTAL:
            blocks.get(0).setPos(pivotRow,pivotCol-1);
            blocks.get(2).setPos(pivotRow,pivotCol+1);
            blocks.get(3).setPos(pivotRow,pivotCol+2);

            state=State.VERTICAL;
            System.out.println("vertical");
            break;
        case VERTICAL:
            blocks.get(0).setPos(pivotRow+1,pivotCol);
            blocks.get(2).setPos(pivotRow-1,pivotCol);
            blocks.get(3).setPos(pivotRow-2,pivotCol);

            state=State.HORIZONTAL;
            System.out.println("horizontal");
            break;
        default:
            break;
        }
    }

}
