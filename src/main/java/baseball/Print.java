package baseball;

import static baseball.Hint.getBall;
import static baseball.Hint.getStrike;

public class Print{

    public static String printResult() {
        String result = "";

        int countStrike = getStrike();
        int countBall = getBall();

        if ( countStrike > 0 && countBall > 0){
            result = String.format("%d볼 %d스트라이크", countBall, countStrike);
        }
        if (countStrike > 0) {
            result = String.format("%d스트라이크", countStrike);
        }
        if (countStrike == 0 && countBall == 0) {
            result = "낫싱";
        }


        return result;
    }


}
