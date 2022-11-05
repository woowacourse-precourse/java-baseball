package baseball.numbercomparator;

/**
 * 스트라이크의 개수와 볼의 개수를 저장하는 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
public class Score {
    private final int strike; // 스트라이크의 개수
    private final int ball; // 볼의 개수

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }


    public int getBall() {
        return ball;
    }

}
