package baseball;

import java.util.List;

public class Score {
    private int strike;
    private int ball;

    public Score(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.strike = getStrikeCount(computerNumbers, userNumbers);
        this.ball = getBallCount(computerNumbers, userNumbers);
        getResult(strike,ball);
    }

    public static Score getResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return new Score(computerNumbers, userNumbers);
    }

    private int getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumber.get(index) == userNumber.get(index)) {
                strike++;
            }
        }

        return strike;
    }

    private int getBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumber.get(index) == userNumber.get(index)) {
                strike++;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                ball++;
            }
        }

        return ball-strike;
    }

    private void getResult(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
            return;
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            return;
        }
        System.out.println("낫싱");
    }

    public boolean checkThreeStrike() {
        return strike == 3;
    }
}
