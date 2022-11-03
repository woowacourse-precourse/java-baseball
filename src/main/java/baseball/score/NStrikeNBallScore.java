package baseball.score;

public class NStrikeNBallScore implements Score {
    int strike;
    int ball;

    public NStrikeNBallScore(int strike, int ball) {
        if (strike < 0 || ball < 0)
            throw new IllegalArgumentException("strike or ball is more than zero");
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public int getStrike() {
        return strike;
    }

    @Override
    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (ball != 0)
            sb.append(ball + "볼 ");
        if (strike != 0)
            sb.append(strike + "스트라이크 ");
        return sb.toString().trim();
    }
}