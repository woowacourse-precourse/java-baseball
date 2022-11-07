package features;

import static features.Hint.getCountBall;
import static features.Hint.getCountNothing;
import static features.Hint.getCountStrike;

public class Print{

    private static final int countStrike = getCountStrike();
    private static final int countBall = getCountBall();
    private static final int countNothing = getCountNothing();





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
