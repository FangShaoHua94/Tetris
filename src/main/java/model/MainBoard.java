package model;

import model.block.Block;
import model.block.ShapeBlock;

import java.util.ArrayList;

public class MainBoard extends Board{

    public static final int ROW = 24;
    public static final int COL = 14;
    private static final double STARTING_X=0;
    private static final double STARTING_Y=0;
    private ShapeBlock currentBlock;
    private Block[][] mainBoard;

    public MainBoard(){
        super(ROW, COL,STARTING_X,STARTING_Y);
        mainBoard=new Block[ROW][COL];
    }

    public void addNewBlock(ShapeBlock newBlock){
        currentBlock=newBlock;
        newBlock.getBlocks().forEach(block -> mainBoard[block.getRow()][block.getCol()]=block);
    }

    public void update(){
        ArrayList<Block> blocks = new ArrayList<>();
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++) {
                if(mainBoard[i][j]!=null){
                    blocks.add(mainBoard[i][j]);
                }
            }
        }
        mainBoard=new Block[ROW][COL];
        blocks.forEach(block -> mainBoard[block.getRow()][block.getCol()]=block);
    }

    public Block[][] getMainBoard(){
        return mainBoard;
    }

    public boolean validMove(int row, int col){
        return mainBoard[row][col]==null||currentBlock.getBlocks().stream().anyMatch(block->block.equals(mainBoard[row][col]));
    }

    public void print(){
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(mainBoard[i][j]!=null){
                    System.out.print("x ");
                }else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    public boolean ClearLine(){
        boolean clearLine=false;
        for(int i=0;i<ROW;i++){
            boolean lineFilled=true;
            for(int j=0;j<COL;j++){
                if(mainBoard[i][j]==null){
                    lineFilled=false;
                    break;
                }
            }
            if(lineFilled){
                for(int j=0;j<COL;j++){
                    mainBoard[i][j]=null;
                }
                clearLine=true;
            }
        }
        return clearLine;
    }


}
