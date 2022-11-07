package baseball;

import baseball.ball.Ball;
import baseball.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private Balls balls;

    public Computer() {
        balls = new Balls();
    }

    private Ball createBall() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return new Ball(randomNumber);
    }

    private Balls createBalls() {
        while (!balls.validateBallsSize()) {
            Ball candidateBall = createBall();
            if (!balls.hasBall(candidateBall)) {
                balls.containBalls(candidateBall);
            }
        }
        return balls;
    }
}
