package baseball;

import java.util.List;

public class Game {
    private List<Integer> threeDiffDigit;
    public List<Integer> getThreeDiffDigit() {
        return threeDiffDigit;
    }
    public void setThreeDiffDigit(List<Integer> threeDiffDigit) {
        this.threeDiffDigit = threeDiffDigit;
    }

    private int numberOfBall;
    private int numberOfStrike;
    public int getNumberOfBall() {
        return numberOfBall;
    }
    public int getNumberOfStrike() {
        return numberOfStrike;
    }
    public void setNumberOfBall(int numberOfBall) {
        this.numberOfBall = numberOfBall;
    }
    public void setNumberOfStrike(int numberOfStrike) {
        this.numberOfStrike = numberOfStrike;
    }

    private String ballCount;
    public String getBallCount() {
        return ballCount;
    }

    public void setBallCount(String ballCount) {
        this.ballCount = ballCount;
    }

    public void initializeBallCount() {
        numberOfBall = 0;
        numberOfStrike = 0;
        ballCount = null;
    }
}
