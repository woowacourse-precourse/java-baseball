package baseball.view;

public class InputView {
    public static final String REQUEST_PLAYER_INPUT = "숫자를 입력해주세요 : ";
    public static final String REQUEST_PLAY_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void requestPlayerInput() {
        System.out.print(REQUEST_PLAYER_INPUT);
    }

    public static void requestMoreGame() {
        System.out.println(REQUEST_PLAY_MORE_GAME);
    }
}
