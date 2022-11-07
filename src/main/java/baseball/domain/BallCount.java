package baseball.domain;

import baseball.util.GamePrinter;
import java.util.StringJoiner;

public class BallCount {

    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean check() {
        return strike != BaseballGuide.NUMBER_LENGTH;
    }

    public void show() {
        StringJoiner result = new StringJoiner(" ");
        if (ball != 0) {
            result.add(ball + "볼");
        }

        if (strike != 0) {
            result.add(strike + "스트라이크");
        }

        if (result.length() == 0) {
            result.add("낫싱");
        }

        GamePrinter.println(result.toString());
    }

}
