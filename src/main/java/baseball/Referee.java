package baseball;

public class Referee {
    private int strikeCount;
    private int ballCount;

    public Referee() {
        initCount();
    }

    public void initCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void judgeGameResult(Balls hitterBalls, Balls pitcherBalls) {
        hitterBalls.getBalls().forEach(hitterBall ->
                count(hitterBall.getResult(pitcherBalls)));
    }

    private void count(BaseballJudge baseballJudge) {
        if (baseballJudge.equals(BaseballJudge.STRIKE)) {
            strikeCount += 1;
        }

        if (baseballJudge.equals(BaseballJudge.BALL)) {
            ballCount += 1;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
