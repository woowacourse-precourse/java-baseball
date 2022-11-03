package baseball;

public class ScoreBoard {
    private int strikeCount;
    private int ballCount;
    private boolean nothing;


    public ScoreBoard() {
        this.initScore();
    }


    public void initScore() {
        strikeCount = 0;
        ballCount = 0;
        nothing = true;
    }

    public void upStrikeCount() {
        strikeCount++;
        nothing = false;
    }

    public void upBallCount() {
        ballCount++;
        nothing = false;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return nothing;
    }
}
