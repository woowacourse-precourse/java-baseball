package baseball.view;

public class Printer {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String END_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputGuide() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printOnlyBall(int ball) {
        System.out.println(ball + BALL_MESSAGE);
    }

    public static void printOnlyStrike(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
    }

    public static void printStrikeAndBall(int ball, int strike) {
        System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
    }

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printEnd() {
        System.out.println(END_MESSAGE);
    }
    public static void askRestart(){
        System.out.println(RESTART_MESSAGE);
    }
}
