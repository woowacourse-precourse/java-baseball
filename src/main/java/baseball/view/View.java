package baseball.view;

public class View {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";

    private View() {}

    public static void printStartGame() {
        System.out.println(START_GAME);
    }
}
