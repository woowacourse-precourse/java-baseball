package baseball;

import baseball.ball.Ball;
import baseball.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private Balls computerBalls;

    public Computer() {
        computerBalls = new Balls();
    }

    private Ball createComputerBall() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return new Ball(randomNumber);
    }

    private Balls createComputerBalls() {
        while (!computerBalls.validateBallsSize()) {
            Ball candidateBall = createComputerBall();
            if (!computerBalls.hasBall(candidateBall)) {
                computerBalls.containBalls(candidateBall);
            }
        }
        return computerBalls;
    }
}
