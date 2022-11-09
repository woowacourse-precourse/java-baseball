package baseball.view;

public class View {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startGame() {
        System.out.println(START_MESSAGE);
    }

    public static void inputNumber() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void victory() {
        System.out.println(END_MESSAGE);
    }

    public static void restartGame() {
        System.out.println(RETRY_MESSAGE);
    }
}
