package baseball.message;

public class OutputMessage {

    private static final String START_MESSAGE = "숫자 야구게임을 시작합니다";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞추셨습니다. 게임 종료";

    private static final String GAME_BALL = "볼";
    private static final String GAME_STRIKE = "스트라이크";
    private static final String GAME_OUT = "아웃";
    private static final String GAME_NOTHING = "낫싱";

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public void userInputMessage() {
        System.out.println(USER_INPUT_MESSAGE);
    }

    public void gameRestartMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public void setWinMessage() { System.out.println(WIN_MESSAGE); }
}
