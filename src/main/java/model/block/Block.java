package model.block;

import javafx.scene.paint.Color;

public class Block {

    public static final Color BORDER_COLOR =Color.BLACK;
    private int row;
    private int col;
    private Color color;

    public Block(int row,int col, Color color){
        this.row=row;
        this.col=col;
        this.color=color;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public Color getColor(){
        return color;
    }

    public Block duplicateBlockAbove(){
        return new Block(row-1,col,color);
    }

    public Block duplicateBlockBelow(){
        return new Block(row+1,col,color);
    }

    public Block duplicateBlockOnLeft(){
        return new Block(row,col-1,color);
    }

    public Block duplicateBlockOnRight(){
        return new Block(row+1,col,color);
    }

    public void moveUp(){
        col--;
    }

    public void moveDown(){
        col++;
    }

    public void moveLeft(){
        row--;
    }

    public void moveRight(){
        row++;
    }

    public void fall() {

    }
}
