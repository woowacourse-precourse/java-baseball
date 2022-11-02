package baseball.domain.result;

public class CompareResult {

    private static final int ANSWER_COUNT = 3;

    private static final String EMPTY = "낫싱";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String BALL_FORMAT = "%d볼 ";

    private int strike = 0;
    private int ball = 0;

    public boolean isAnswer() {
        return this.strike == ANSWER_COUNT;
    }

    public void addStrike() {
        this.strike ++;
    }

    public void addBall() {
        this.ball ++;
    }

    @Override
    public String toString() {
        if ((strike | ball) == 0) {
            return EMPTY;
        }

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(String.format(BALL_FORMAT, ball));
        }

        if (strike > 0) {
            sb.append(String.format(STRIKE_FORMAT, strike));
        }

        // `볼` 만 있을 경우 공백 제거하기 위함
        return sb.toString().trim();
    }
}
