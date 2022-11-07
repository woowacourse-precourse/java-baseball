package features;

import static features.Hint.getCountBall;
import static features.Hint.getCountNothing;
import static features.Hint.getCountStrike;

import java.util.Map;

public class Print{

    private static int countStrike = getCountStrike();
    private static int countBall = getCountBall();
    private static int countNothing = getCountNothing();

    private static String strike = String.format("%d스트라이크", countStrike);
    private static String ball = String.format("%d볼 %d스트라이크", countBall, countStrike);
    private static String nothing = "낫싱";



    public static String printResult() {
        String result = "";

        if (countStrike == 3) {
            result = strike;
        }
        if (countBall > 1) {
            result = ball;
        }
        if (countNothing == 3) {
            return nothing;
        }

        return result;
    }


}
