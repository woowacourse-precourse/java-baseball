package baseball.domain;

import baseball.util.GamePrinter;
import baseball.util.GameValidator;

public class BallCount {

    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean check() {
        return strike != GameValidator.NUMBER_LENGTH;
    }

    public void show() {
        StringBuilder result = new StringBuilder();
        if (ball == 0 && strike == 0) {
            result.append("낫싱");
        }

        if (ball != 0) {
            result.append(ball).append("볼").append(" ");
        }

        if (strike != 0) {
            result.append(strike).append("스트라이크");
        }

        if (strike == GameValidator.NUMBER_LENGTH) {
            result.append("\n").append(GameValidator.NUMBER_LENGTH)
                .append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        GamePrinter.println(result.toString().stripTrailing());
    }
}
