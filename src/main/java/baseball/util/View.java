package baseball.util;

public class View {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_GUESS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REQUEST_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRequestPlayerGuess() {
        System.out.println(REQUEST_GUESS_MESSAGE);
    }

    public static void printGameFinish() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    public static void printRequestRestart() {
        System.out.println(REQUEST_RESTART_MESSAGE);
    }
}
