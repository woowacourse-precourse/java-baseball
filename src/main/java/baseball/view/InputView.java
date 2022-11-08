package baseball.view;

public class InputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String CHOICE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage() {
        System.out.println(GAME_START);
    }

    public static void printInputMessage() {
        System.out.print(ENTER_NUMBER);
    }

    public static void printChoiceMessage() {
        System.out.println(CHOICE_MESSAGE);
    }
}
