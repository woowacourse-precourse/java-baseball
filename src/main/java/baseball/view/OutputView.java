package baseball.view;

import baseball.model.Score;

public class OutputView {
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_QUIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResultMessage(Score score) {
        String resultMessage = score.makeResultMessage(BALL_MESSAGE, STRIKE_MESSAGE, NOTHING_MESSAGE);
        System.out.println(resultMessage);
    }

    public static void printQuitMessage() {
        System.out.println(GAME_QUIT_MESSAGE);
    }
}
