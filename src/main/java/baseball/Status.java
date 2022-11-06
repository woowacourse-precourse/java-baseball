package baseball;

public class Status {
    private final int strike;
    private final int ball;

    public Status(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean correct() {
        return strike == Numbers.LENGTH;
    }

    @Override
    public String toString() {
        StringBuilder status = new StringBuilder();
        if (ball > 0) {
            status.append(ball).append("볼 ");
        }
        if (strike > 0) {
            status.append(strike).append("스트라이크 ");
        }
        if (status.length() == 0) {
            status.append("낫싱");
        }
        return status.toString().trim();
    }
}
