package baseball.view;

public class InputView {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";

    public static void printStartMessage() {
        System.out.println(GAME_START);
        printInputMessage();
    }

    private static void printInputMessage() {
        System.out.println(ENTER_NUMBER);
    }
}
