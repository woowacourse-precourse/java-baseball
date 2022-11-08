package baseball;

import java.util.Map;

public class PrintLine {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String AFTER_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_NUMBER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_MESSAGE = "게임 종료";

    public static void startGamePrint() {
        System.out.println(START_MESSAGE);
    }

    public static void putUserNumberPrint() {
        System.out.print(USER_NUMBER_MESSAGE);
    }

    public static void putRestartNumberPrint() {
        System.out.println(RESTART_NUMBER_MESSAGE);
    }

    public static void resultPrint(Map<String, Integer> scoreTable) {
        if (scoreTable.get("스트라이크") == 0 && scoreTable.get("볼") == 0) {
            System.out.print("낫싱");
        }
        if (scoreTable.get("볼") != 0) {
            System.out.print(scoreTable.get("볼") + "볼 ");
        }
        if (scoreTable.get("스트라이크") != 0) {
            System.out.print(scoreTable.get("스트라이크") + "스트라이크");
        }
        System.out.println();
    }

    public static void afterAnswerPrint() {
        System.out.println(AFTER_ANSWER_MESSAGE);
    }

    public static void endGame() {
        System.out.println(END_MESSAGE);
    }
}
