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

    public String play() {
        List<Integer> computerBall = ballMaker.getRandomBall();
        boolean finishGame = false;
        while (finishGame != true) {
            List<Integer> userBall = ballMaker.getUserBall();
            finishGame = ballReader.isFinished(userBall, computerBall);
            printResult(userBall, computerBall);
            numberOfAttempts += 1;
        }
        System.out.printf(ENDING_MESSAGE, numberOfBall);
        return "";
    }

}
