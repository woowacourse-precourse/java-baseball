package baseball.io;

import baseball.model.BallStatus;

public class ConsoleOutput implements Output {
    private static final String START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String END_TEXT = "개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

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

    @Override
    public void printEndText(BallStatus ballStatus) {
        System.out.println(ballStatus.getStrike() + END_TEXT);
    }
}
