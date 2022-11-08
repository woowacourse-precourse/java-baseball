package baseball.view;

import java.util.List;

public class BaseballGameView {
    private static final BaseballGameView baseballGameView = new BaseballGameView();
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ROUND_CLEAR_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_STRIKE_COUNT_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String NOTHING_MATCHED_MESSAGE = "낫싱";
    private static final String GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private BaseballGameView() {
    }

    public static BaseballGameView getInstance() {
        return baseballGameView;
    }

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInsertNumbersMessage() {
        System.out.print(USER_INPUT_MESSAGE);
    }

    public void printComparedResult(List<Integer> comparedResult) {
        int ballCnt = comparedResult.get(0);
        int strikeCnt = comparedResult.get(1);

        if (strikeCnt == 3) {
            System.out.println(ROUND_CLEAR_MESSAGE);
            return;
        } else if (ballCnt != 0 || strikeCnt != 0) {
            System.out.printf(BALL_STRIKE_COUNT_MESSAGE, ballCnt, strikeCnt);
            return;
        }

        System.out.println(NOTHING_MATCHED_MESSAGE);
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
