package baseball;


public class ScoreBoard {
    private int strikeCount;
    private int ballCount;



    public ScoreBoard() {
        this.initiate();
    }


    public void initiate() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void upStrikeCount() {
        this.strikeCount++;
    }

    public void upBallCount() {
        this.ballCount++;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public boolean isNoScore() {
        if (this.ballCount > 0 || this.strikeCount > 0) {
            return false;
        }

        return true;
    }
}
