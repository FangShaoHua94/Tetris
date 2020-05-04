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

    public boolean isValidUpMove(){
        return !outOfBound(row-1,col);
    }

    public void moveDown(){
        row++;
    }

    public boolean isValidDownMove(){
        return !outOfBound(row+1,col);
    }

    public void moveLeft(){
        col--;
    }

    public boolean isValidLeftMove(){
        return !outOfBound(row,col-1);
    }

    public void moveRight(){
        col++;
    }

    public boolean isValidRightMove(){
        return !outOfBound(row,col+1);
    }

    public boolean outOfBound(int row, int col){
        if(row<0 || row >= MainBoard.ROW || col<0 || col>= MainBoard.COL){
            return true;
        }
        return false;
    }



}
