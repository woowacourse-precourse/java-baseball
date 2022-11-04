package baseball.game;

import baseball.util.BallGenerator;
import java.util.List;

public class Ball {

    private final BallGenerator ballGenerator;

    public Ball() {
        this.ballGenerator = new BallGenerator();
    }

    public List<Integer> getComputerBall() {
        return ballGenerator.createComputerBall();
    }

    public List<Integer> getPlayerBall() {
        return ballGenerator.createPlayerBall();
    }
}
