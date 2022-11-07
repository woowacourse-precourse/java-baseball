package baseball.view;

public class InputView {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INSERT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void gameStart() {
        System.out.println(GAME_START);
    }

    public static void insertNumber() {
        System.out.print(INSERT_NUMBER);
    }

    public static void restartGame() {
        System.out.println(RESTART_GAME);
    }
}
