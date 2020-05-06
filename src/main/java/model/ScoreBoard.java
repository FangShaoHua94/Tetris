package model;

public class ScoreBoard extends Board {

    private static final double STARTING_X = 325;
    private static final double STARTING_Y = 50;
    private int score;
    private int highScore;

    public ScoreBoard(int highScore) {
        super(STARTING_X, STARTING_Y);
        this.highScore=highScore;
        score = 0;
    }

    public void AddScore(int score) {
        this.score += score;
        updateHighScore();
    }

    public void updateHighScore(){
        if(highScore<score){
            highScore=score;
        }
    }

    public int getScore() {
        return score;
    }

    public int getHighScore(){
        return highScore;
    }

}
