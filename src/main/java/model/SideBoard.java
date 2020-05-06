package model;

public class SideBoard extends Board {

    public static final int SIDE_BOARD_SIZE = 10;
    private static final int ROW = 60;
    private static final int COL = 20;
    private static final double STARTING_X = 300;
    private static final double STARTING_Y = 0;
    private NextBlockBoard nextBlockBoard;
    private ScoreBoard scoreBoard;

    public SideBoard(int highScore) {
        super(ROW, COL, STARTING_X, STARTING_Y);
        nextBlockBoard = new NextBlockBoard();
        scoreBoard = new ScoreBoard(highScore);
    }

    public NextBlockBoard getNextBlockBoard() {
        return nextBlockBoard;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

}
