package baseball.game;

import java.util.EnumMap;

public class Game {
    private int ballSize;

    private BallMaker ballMaker;
    private Ball computerBall;
    private boolean endGame;

    public Game() {
        this.ballSize = 3;
        this.ballMaker = new BallMaker();
        this.computerBall = ballMaker.getUniqueRandomBall(ballSize);
        this.endGame = false;
    }

    public Game(BallMaker ballMaker) {
        this.ballSize = 3;
        this.ballMaker = ballMaker;
        this.computerBall = ballMaker.getUniqueRandomBall(ballSize);
        this.endGame = false;
    }

    public Game(int ballCount) {
        this.ballSize = ballCount;
        this.ballMaker = new BallMaker();
        this.computerBall = ballMaker.getUniqueRandomBall(ballCount);
        this.endGame = false;
    }

    public EnumMap<ResultOfBall, Integer> throwBall(Ball ball) {
        checkGameStatus(ball);
        return computerBall.getBallResult(ball);
    }

    public boolean isEndGame() {
        return this.endGame;
    }

    public int getBallSize() {
        return ballSize;
    }

    public void restartGame() {
        this.endGame = false;
        this.computerBall = ballMaker.getUniqueRandomBall(ballSize);
    }

    private void checkGameStatus(Ball ball) {
        if (computerBall.isAllStrike(ball)) {
            this.endGame = true;
        }
    }

}
