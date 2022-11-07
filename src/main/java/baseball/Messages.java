package baseball;

public class Messages {
    private static final String END_MESSAGE = "게임 종료";
    private static final String CLEAR_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final int ZERO = 0;

    public static void printGameResult(int balls, int strikes) {
        printBalls(balls);
        printStrikes(strikes);
        printNothing(balls, strikes);
        System.out.println();
    }

    private static void printBalls(int balls) {
        if (balls > ZERO) {
            System.out.print(balls + BALL);
        }
    }

    private static void printStrikes(int strikes) {
        if (strikes > ZERO) {
            System.out.println(strikes + STRIKE);
        }
    }

    private static void printNothing(int balls, int strikes) {
        if (balls == ZERO && strikes == ZERO) {
            System.out.println(NOTHING);
        }
    }

    public static void printClearMessage() {
        System.out.println(Application.NUMBER_LENGTH()+CLEAR_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
