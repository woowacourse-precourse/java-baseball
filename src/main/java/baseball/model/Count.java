package baseball.model;

public class Count {
    private int ballCount = 0;
    private int strikeCount = 0;

    public void countBall(){
        this.ballCount++;
    }

    public void countStrike(){
        this.strikeCount++;
    }

    public int getBallCount(){
        return this.ballCount;
    }

    public int getStrikeCount(){
        return this.strikeCount;
    }

}
