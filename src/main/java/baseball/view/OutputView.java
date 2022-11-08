package baseball.view;

public class OutputView {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void print(String message) {
        System.out.print(message);
    }

    public void printWithLine(String message) {
        System.out.println(message);
    }
}
