package baseball;

import static baseball.Compare.BALL_INDEX;
import static baseball.Compare.STRIKE_INDEX;

import java.util.List;

public class OutputView {
    private static final String GAME_START_STR = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_STR = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_HINT_STR = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public void printGameStart() {
        System.out.println(GAME_START_STR);
    }

    public void printInputHint() {
        System.out.print(INPUT_HINT_STR);
    }

    public void printResult(List<Integer> answer) {
        if (answer.get(BALL_INDEX) > 0) {
            System.out.printf("%d" + BALL, answer.get(BALL_INDEX));
        }
        if (answer.get(STRIKE_INDEX) > 0) {
            System.out.printf("%d" + STRIKE + "\n", answer.get(STRIKE_INDEX));
        }
        if (answer.get(STRIKE_INDEX) == 0 && answer.get(BALL_INDEX) == 0) {
            System.out.println("낫싱");
        }
    }

    public void printGameEnd(List<Integer> answer) {
        System.out.printf(GAME_END_STR, answer.get(STRIKE_INDEX));
    }
}
