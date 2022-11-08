package baseball.model;

import java.util.List;

public class GameJudge {
    public static boolean allStrike = false;

    public static String judgeGameResult(List<Integer> playerNumber, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < playerNumber.size(); i++) {
            if (isStrike(playerNumber.get(i), computerNumber.get(i))) {
                strike++;
                continue;
            }
            if (isBall(playerNumber.get(i), computerNumber)) {
                ball++;
            }
        }
        isAllStrike(strike);
        return changeResultMessage(strike, ball);
    }

    private static boolean isStrike(int player, int computer) {
        if (player == computer) {
            return true;
        }
        return false;
    }

    private static boolean isBall(int player, List<Integer> computerNumberList) {
        for (Integer number : computerNumberList) {
            if (player == number) {
                return true;
            }
        }
        return false;
    }

    private static void isAllStrike(int strike) {
        if (strike == 3) {
            allStrike = true;
        } else {
            allStrike = false;
        }
    }

    private static String changeResultMessage(int strike, int ball) {
        String result = "";
        if (ball > 0) {
            result = ball + "볼";
        }
        if (strike > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += strike + "스트라이크";
        }
        if (result.isEmpty()) {
            result = "낫싱";
        }
        return result;
    }
}
