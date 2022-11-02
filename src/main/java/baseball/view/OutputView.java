package baseball.view;

public enum OutputView {
    INSTANCE;

    private final static String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";

    public void startBaseballGame() {
        System.out.println(START_BASEBALL_GAME);
    }
}
