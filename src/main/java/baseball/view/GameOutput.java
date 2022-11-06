package baseball.view;

public class GameOutput {

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL_STRIKE = "%d볼 %d스트라이크\n";
    private static final String STRIKE = "%d스트라이크\n";
    private static final String BALL = "%d볼\n";
    private static final String NOTHING = "낫싱";

    public static void printStartGame() {
        System.out.println(START);
    }

    public static void printUserInputMessage() {
        System.out.println(USER_INPUT_MESSAGE);
    }

    public static void printEndGame() {
        System.out.println(END);
    }

    public static void printRestartGame() {
        System.out.println(RESTART);
    }

    public static void printBallAndStrike(int ball, int strike) {
        System.out.printf(BALL_STRIKE, ball, strike);
    }

    public static void printStrike(int strike) {
        System.out.printf(STRIKE, strike);
    }

    public static void printBall(int ball) {
        System.out.printf(BALL, ball);
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }
}
