package baseball;

public class Print {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_ENTER_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String GAME_END_CHOICE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void enterNumber() {
        System.out.printf(NUMBER_ENTER_MESSAGE);
    }

    public static void checkGameEnd() {
        System.out.println(GAME_END_MESSAGE);
        System.out.println(GAME_END_CHOICE_MESSAGE);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
