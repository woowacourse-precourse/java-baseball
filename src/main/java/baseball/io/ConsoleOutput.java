package baseball.io;

import baseball.model.BallStatus;

public class ConsoleOutput implements Output {
    private static final String START_TEXT = "숫자 야구 게임을 시작합니다.";

    @Override
    public void printStartText() {
        System.out.println(START_TEXT);
    }

    @Override
    public void printScore(BallStatus ballStatus) {
        if (ballStatus == null) {
            throw new IllegalArgumentException();
        }

        System.out.println(ballStatus);
    }
}
