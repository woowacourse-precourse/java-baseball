package baseball.view;

public class ConsoleView {

    private final static String WELCOME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
    public void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public void printSuccessMessage() {
        System.out.print(SUCCESS_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }
}
