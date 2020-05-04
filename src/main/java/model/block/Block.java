package model.block;

import javafx.scene.paint.Color;
import model.MainBoard;

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

    public void setRow(int row){
        setPos(col,row);
    }

    public void setCol(int col){
        setPos(col,row);
    }

    public void setPos(int row,int col){
        this.row=row;
        this.col=col;
    }

    public void moveUp(){
        row--;
    }

    public void moveDown(){
        row++;
    }

    public void moveLeft(){
        col--;
    }

    public void moveRight(){
        col++;
    }

}
