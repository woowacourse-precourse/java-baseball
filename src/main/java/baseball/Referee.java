package baseball;

import java.util.List;

public class Referee {
    int strike;
    int ball;

    protected void calculateBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        clearBallCount();
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
    }

    protected void clearBallCount() {
        strike = 0;
        ball = 0;
    }

    protected void printBallCount(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

}