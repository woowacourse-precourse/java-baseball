package baseball.view;

public class OutputView {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    public void printStart() {
        System.out.println(GAME_START);
    }

    public void printBallAndStrike(Integer numberOfBall, Integer numberOfStrike) {
        if (numberOfBall == 0 && numberOfStrike == 0) System.out.println(NOTHING);
        if (numberOfBall > 0 && numberOfStrike == 0) System.out.println(numberOfBall + BALL);
        if (numberOfBall == 0 && numberOfStrike > 0) System.out.println(numberOfStrike + STRIKE);
        if (numberOfBall > 0 && numberOfStrike > 0) System.out.println(numberOfBall + BALL + " " + numberOfStrike + STRIKE);
    }
}
