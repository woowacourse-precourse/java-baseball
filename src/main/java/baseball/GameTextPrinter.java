package baseball;

public class GameTextPrinter {
    private static final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_TEXT = "숫자를 입력해주세요 : ";

    public static void printGameStartText() {
        System.out.println(GAME_START_TEXT);
    }

    public static void printUserInputText() {
        System.out.print(USER_INPUT_TEXT);
    }
}
