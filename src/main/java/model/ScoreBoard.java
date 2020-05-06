package model;

public class ScoreBoard extends Board {

    private static final int ROW = 24;
    private static final int COL = 8;
    private static final double STARTING_X = 325;
    private static final double STARTING_Y = 50;
    private int score;

    public ScoreBoard() {
        super(ROW, COL, STARTING_X, STARTING_Y);
        score = 0;
    }

    public void AddScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

}
