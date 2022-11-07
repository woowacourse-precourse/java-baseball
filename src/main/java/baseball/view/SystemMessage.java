package baseball.view;

import static baseball.utils.Constants.GAME_END;
import static baseball.utils.Constants.GAME_RESTART;

public class SystemMessage {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESULT_NOTHING_MESSAGE = "낫싱";
    private static final String RESULT_BALL_MESSAGE = "볼";
    private static final String RESULT_STRIKE_MESSAGE = "스트라이크";
    private static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printGameStartMessage() {
        System.out.print(GAME_START_MESSAGE);
    }

    public static void requestInputNumberMessage() {
        System.out.print(REQUEST_INPUT_MESSAGE);
    }

    public static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(RESULT_NOTHING_MESSAGE);
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + RESULT_STRIKE_MESSAGE);
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + RESULT_BALL_MESSAGE);
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + RESULT_BALL_MESSAGE + " " + strike + RESULT_STRIKE_MESSAGE);
        }
    }
}
