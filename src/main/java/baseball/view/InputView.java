package baseball.view;

public class InputView {
    private static final String INPUT_HINT_STR = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void inputGuessThreeNumbers() {
        System.out.print(INPUT_HINT_STR);
    }

    public static void inputRestartOrExitNumber() {
        System.out.println(RESTART_OR_EXIT);
    }
}
