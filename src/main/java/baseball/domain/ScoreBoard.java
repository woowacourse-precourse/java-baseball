package baseball.domain;

import java.util.List;

public class ScoreBoard {
    private static int ball;
    private static int strike;

    public static void judge(List<Integer> computerBalls, List<Integer> myBallNumbers) {
        for (int number : myBallNumbers) {
            if (computerBalls.contains(number)) {
                ball++;
            }

            if (checkStrike(computerBalls, myBallNumbers, number)) {
                ball--;
                strike++;
            }
        }

        printScoreBoard();
    }

    private static void printScoreBoard() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }

        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static boolean checkStrike(List<Integer> computerBalls, List<Integer> myBallNumbers, int number) {
        return myBallNumbers.indexOf(number) == computerBalls.indexOf(number);
    }
}
