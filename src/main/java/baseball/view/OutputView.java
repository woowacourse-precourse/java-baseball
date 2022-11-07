package baseball.view;

public class OutputView {
    public static final String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";
    public static final String RIGHT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartGame() {
        System.out.println(START_BASEBALL_GAME);
    }

    public static void printRightAnswer() {
        System.out.println(RIGHT_ANSWER);
    }

    public static void printHintResult(String hintResult) {
        System.out.println(hintResult);
    }
}
