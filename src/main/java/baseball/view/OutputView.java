package baseball.view;

public class OutputView {
    private static final String STRIKE_MESSAGE = "%d스트라이크 ";
    private static final String BALL_MESSAGE = "%d볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를모두 맞히셨습니다! 게임 종료";

    public static void printResult(int strike, int ball){
        if (ball > 0) {
        printBallMessage(ball);
        }
        if (strike > 0) {
            printStrikeMessage(strike);
        }
        if (strike == 0 && ball == 0) {
            printNothingMessage();
        }
        System.out.printf("\n");
    }

    public static void printSuccess() {
        System.out.printf(SUCCESS_MESSAGE + "\n");
    }

    private static void printStrikeMessage(int strike) {
        System.out.printf(STRIKE_MESSAGE, strike);
    }

    private static void printBallMessage(int ball) {
        System.out.printf(BALL_MESSAGE, ball);
    }

    private static void printNothingMessage() {
        System.out.printf(NOTHING_MESSAGE);
    }
}