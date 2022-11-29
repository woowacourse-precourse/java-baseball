package baseball.view;

import baseball.model.Hint;
import baseball.model.Judge;

public class OutputView {
    private static final String START_GAME= "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR= "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStart() {
        System.out.println(START_GAME);
    }

    public static void printGameClear() {
        System.out.println(GAME_CLEAR);
    }

    public static void printHint(Judge judge) {
        String message = judge.getHintMessage();
        System.out.println(message);
    }
}
