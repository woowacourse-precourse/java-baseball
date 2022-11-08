package baseball.domain;

public class Score {
    private int strike;
    private int ball;

    public Score(int strikeScore, int ballScore) {
        this.strike = strikeScore;
        this.ball = ballScore;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (strike == 0 && ball == 0) {
            ret.append("낫싱");
        }
        else {
            if (ball != 0) {
                ret.append(ball);
                ret.append("볼 ");
            }
            if (strike != 0) {
                ret.append(strike);
                ret.append("스트라이크");
            }
        }
        return ret.toString();
    }
}
