package baseball.view.print;

public class PrintGuideMessage {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(PLAYER_INPUT_MESSAGE);
    }

    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public static void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }
}