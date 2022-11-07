package baseball;

import java.util.List;

public class Output {
    public static String result(List<Integer> computer, List<Integer> player){
        int total = Compare.countTotal(computer, player);
        int strike = Compare.countStrike(computer, player);
        int ball = Compare.countBall(computer, player);

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
