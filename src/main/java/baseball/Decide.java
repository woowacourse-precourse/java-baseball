package baseball;

import java.util.List;

public class Decide {
    Baseball baseball = new Baseball();

    public String finalanswer(List<Integer> computer, List<Integer> player) {
        int total = baseball.compare(computer, player);
        int strike = baseball.countStrike(computer, player);
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
