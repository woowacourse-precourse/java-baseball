package baseball;

public class BaseBallGameView {
    private static String NOTHING = "낫싱";
    private static String BALL = "볼";
    private static String STRIKE = "스트라이크";
    private static String FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }

        if (strike == 3) {
            System.out.println(strike + STRIKE);
            System.out.println(FINISH);
            return;
        }

        if (ball != 0)
            System.out.print(ball + BALL + " ");

        if (strike != 0)
            System.out.print(strike + STRIKE);

        System.out.println();
    }
}
