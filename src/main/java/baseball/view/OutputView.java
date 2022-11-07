package baseball.view;

public class OutputView {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String END_OR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void inputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void gameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void endOrRestartMessage() {
        System.out.println(END_OR_RESTART_MESSAGE);
    }
}
