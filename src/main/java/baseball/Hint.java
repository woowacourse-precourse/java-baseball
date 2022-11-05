package baseball;

public class Hint {
    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean correct() {
        return strike == Numbers.LENGTH;
    }

    @Override
    public String toString() {
        StringBuilder hint = new StringBuilder();
        if (ball > 0) {
            hint.append(ball).append("볼 ");
        }
        if (strike > 0) {
            hint.append(strike).append("스트라이크 ");
        }
        if (hint.length() == 0) {
            hint.append("낫싱");
        }
        return hint.toString().trim();
    }
}
