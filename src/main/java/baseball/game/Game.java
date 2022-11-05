package baseball.game;

import java.util.List;
import java.util.Map;

public class Game {

    private int numberOfBall;
    private int numberOfAttempts = 0;

    BallMaker ballMaker;
    BallReader ballReader;

    public Game() {
        this.numberOfBall = 3;
        this.ballMaker = new BallMaker();
        this.ballReader = new BallReader();
    }

    public Game(BallMaker ballMaker, BallReader ballReader) {
        this.numberOfBall = 3;
        this.ballMaker = ballMaker;
        this.ballReader = ballReader;
    }

}
