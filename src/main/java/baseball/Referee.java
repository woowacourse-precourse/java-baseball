package baseball;

import java.util.List;

public class Referee {
    public static int correctNumberCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int count = 0;
        for (int i = 0; i < playerNumber.size(); i += 1) {
            if (computerNumber.contains(playerNumber.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    public static Integer getStrikeCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;
        for (int i = 0; i < playerNumber.size(); i += 1) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public static Integer getBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = getStrikeCount(computerNumber, userNumber);
        int ball = correctNumberCount(computerNumber, userNumber) - strike;

        return ball;
    }

    public static boolean checkNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

}
