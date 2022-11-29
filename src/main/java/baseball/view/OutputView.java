package baseball.view;

public class OutputView {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.\n";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }
}
