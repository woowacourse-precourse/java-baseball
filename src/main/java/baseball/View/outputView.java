package baseball.View;

public class outputView {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";


    public static void printBallAndStrike(int strikeNumber, int ballNumber) {
        if(strikeNumber !=0 && ballNumber != 0) {
            System.out.println(strikeNumber + STRIKE + ballNumber+ BALL);
        }
        if(strikeNumber != 0) {
            System.out.println(strikeNumber + STRIKE);
        }
        if(ballNumber != 0) {
            System.out.println(ballNumber + BALL);
        }
    }


    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }
}
