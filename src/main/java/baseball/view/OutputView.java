package baseball.view;

public class OutputView {

    public static final String START_GAME = "숫자 야구 게임을 시작합니다.";

    public static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String PLAY_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";

    public void print(String message) {
        System.out.print(message);
    }

    public void printWithLine(String message) {
        System.out.println(message);
    }
}
