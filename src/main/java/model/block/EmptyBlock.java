package model.block;

import javafx.scene.paint.Color;

public class EmptyBlock extends Block implements Passable{

    private static final int ROW=1;
    private static final int COL=1;
    private static final Color COLOR=Color.BLACK;

    public EmptyBlock() {
        super(ROW, COL, COLOR);
    }

}
