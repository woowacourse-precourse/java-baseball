package baseball;

public class Print{

    private static int countStrike;
    private static int countBall;
    private static int countNothing;

    public Print(Hint hint) {
        this.countStrike = hint.getStrike();;
        this.countBall = hint.getBall();;
        this.countNothing = hint.getNothing();;
    }

    public static String printResult() {
        String result = "";

        if (countStrike == 3) {
            result = String.format("%d스트라이크", countStrike);;
        }
        if (countBall > 1) {
            result = String.format("%d볼 %d스트라이크", countBall, countStrike);;
        }
        if (countNothing == 3) {
            result = "낫싱";
        }

        return result;
    }


}
