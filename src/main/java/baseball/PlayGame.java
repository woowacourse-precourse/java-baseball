package baseball;

import java.util.List;

public class PlayGame {
    private int strike;
    private int ball;
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    public PlayGame(List<Integer> setComputerNumber, List<Integer> setUserNumber) {
        this.computerNumber = setComputerNumber;
        this.userNumber = setUserNumber;
    }

    public int checkStrikeAndBall() {
        compareNumberForStrike();
        compareNumberForBall();
        outputResult();
        return strike;
    }

    public List<Integer> checkStrikeAndBallForTest() {
        compareNumberForStrike();
        compareNumberForBall();
        List<Integer> ballStrike = List.of(ball, strike);
        return ballStrike;
    }

    public String outputResultForTest(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private void compareNumberForStrike() {
        int digit = 0;
        int methodCallCount = 0;

        while (methodCallCount < 3) {
            int beforeStrike = strike;

            countStrike(computerNumber.get(methodCallCount), userNumber.get(digit));
            digit = exceptStrikeNumber(beforeStrike, digit);

            digit++;
            methodCallCount++;
        }
    }

    private void countStrike(int computerStrikeNumber, int userStrikeNumber) {
        if (computerStrikeNumber == userStrikeNumber) {
            strike++;
        }
    }

    private int exceptStrikeNumber(int beforeStrike, int digit) {
        if (beforeStrike != strike) {
            userNumber.remove(digit);
            digit--;
        }
        return digit;
    }

    private void compareNumberForBall() {
        int compareNumberIndex = 0;

        while (compareNumberIndex < userNumber.size()) {
            countBall(compareNumberIndex);
            compareNumberIndex++;
        }
    }

    private void countBall(int index) {
        if (computerNumber.contains(userNumber.get(index))) {
            ball++;
        }
    }

    private void outputResult() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
        return;
    }
}
