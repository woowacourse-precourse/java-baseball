package baseball.domain;

import java.util.List;

public class ScoreBoard {
    private static int ball;
    private static int strike;

    public static String judge(List<Integer> computerBalls, List<Integer> myBallNumbers) {
        for (int number : myBallNumbers) {
            if (computerBalls.contains(number)) {
                ball++;
            }

            if (checkStrike(computerBalls, myBallNumbers, number)) {
                ball--;
                strike++;
            }
        }

        String scoreResult = printScoreBoard();
        return scoreResult;
    }

    private static String printScoreBoard() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball == 0 && strike != 0) {
            return strike + "스트라이크";
        }

        if (ball != 0 && strike == 0) {
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    private static boolean checkStrike(List<Integer> computerBalls, List<Integer> myBallNumbers, int number) {
        return myBallNumbers.indexOf(number) == computerBalls.indexOf(number);
    }
}
