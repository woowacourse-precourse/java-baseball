package baseball;


public class ScoreBoard {
    private int strikeCount;
    private int ballCount;
    private boolean nothing;


    public ScoreBoard() {
        this.initScore();
    }


    public void initScore() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.nothing = true;
    }

    public void upStrikeCount() {
        this.strikeCount++;
        this.nothing = false;
    }

    public void upBallCount() {
        this.ballCount++;
        this.nothing = false;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public boolean isNothing() {
        return this.nothing;
    }
}
