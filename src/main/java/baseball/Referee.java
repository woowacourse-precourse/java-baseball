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

    public static String compare(List<Integer> computerNumber, List<Integer> userNumber) {
        String result = "";
        int strike = getStrikeCount(computerNumber, userNumber);
        int ball = getBallCount(computerNumber, userNumber);
        if (checkNothing(strike, ball)) {
            result += "낫싱";
            return result;
        } else if (strike == 0) {
            result += ball + "볼";
            return result;
        } else if (ball == 0) {
            result += strike + "스트라이크";
            return result;
        }
        result += ball + "볼 " + strike + "스트라이크";
        return result;
    }
}
