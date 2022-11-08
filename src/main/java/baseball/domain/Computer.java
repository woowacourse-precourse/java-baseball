package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Ball> balls;

    public Computer() {
    }

    Computer(List<Ball> balls) {
        this.balls = balls;
    }

    public void init() {
        List<Integer> threeRandomNumber = getThreeRandomNumber();
        balls = BallGenerator.getBalls(threeRandomNumber);
    }

    private List<Integer> getThreeRandomNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = getRandomNumber();
            if (isContains(list, randomNumber)) {
                continue;
            }
            list.add(randomNumber);
        }
        return list;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private boolean isContains(List<Integer> list, int randomNumber) {
        return list.contains(randomNumber);
    }

    public String getResult(List<Ball> assumption) {
        int strike = getStrike(assumption);
        int ball = getBall(assumption);
        return getAnswer(strike, ball);
    }

    private int getStrike(List<Ball> assumption) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (isStrike(balls.get(i), assumption.get(i))) strike++;
        }
        return strike;
    }

    private boolean isStrike(Ball ball1, Ball ball2) {
        return isSamePosition(ball1, ball2) && isSameNumber(ball1, ball2);
    }

    private boolean isSamePosition(Ball ball1, Ball ball2) {
        return ball1.getPosition() == ball2.getPosition();
    }

    private boolean isSameNumber(Ball ball1, Ball ball2) {
        return ball1.getNumber() == ball2.getNumber();
    }

    private int getBall(List<Ball> assumption) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            ball += isBallWithPosition(assumption, i);
        }
        return ball;
    }

    private int isBallWithPosition(List<Ball> assumption, int position) {
        for (int j = 0; j < 3; j++) {
            if (isBall(balls.get(position), assumption.get(j))) return 1;
        }
        return 0;
    }

    private boolean isBall(Ball ball1, Ball ball2) {
        return !isSamePosition(ball1, ball2) && isSameNumber(ball1, ball2);
    }

    private String getAnswer(int strike, int ball) {
        if (isNothing(strike, ball)) {
            return "낫싱";
        }
        if (isNoBall(ball)) {
            return strike + "스트라이크";
        }
        if (isNoStrike(strike)) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
    private boolean isNoBall(int ball) {
        return ball == 0;
    }

    private boolean isNoStrike(int strike) {
        return strike == 0;
    }
}
