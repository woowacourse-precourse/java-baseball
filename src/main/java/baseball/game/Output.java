package baseball.game;

public class Output {

    private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String CORRECT_NUMBER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void numberInput() {
        System.out.print(NUMBER_INPUT);
    }

    public static void startGame() {
        System.out.println(START_GAME);
    }

    public static void endGame() {
        System.out.println(CORRECT_NUMBER);
    }

    public static void restartOrEnd() {
        System.out.println(RESTART_OR_END);
    }
}
