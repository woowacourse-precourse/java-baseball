package baseball.game;

import baseball.ball.Balls;
import util.Input;
import util.Output;
import util.RandomUniqueNumber;

import java.util.List;

public class Game {
    public static final int BALL_SIZE = 3;
    public GameStatus gameStatus;
    public BaseballStatus baseballStatus;

    public Game() {
        this.gameStatus = GameStatus.PROGRESSING;
    }

    public void playGame() {
        while (gameStatus.isProgressing()) {
            baseballStatus = BaseballStatus.GUESSING;

            List<Integer> randomUniqueNumbers = RandomUniqueNumber.getRandomUniqueNumbers(BALL_SIZE);
            gameStatus = playBaseball(randomUniqueNumbers);
        }
    }

    public GameStatus playBaseball(List<Integer> randomUniqueNumbers) {
        Balls computer = new Balls(randomUniqueNumbers);
        Output.printStart();

        while (baseballStatus.isGuessing()) {
            Output.printWaitForInput();
            List<Integer> playerNumbers = Input.makeListFromInput();
            Balls player = new Balls(playerNumbers);

            GameResult gameResult = computer.compare(player);
            Output.printScore(gameResult);
            baseballStatus = gameResult.determineCorrect();
        }

        Output.printGameOver();
        return Input.readLineAfterGame();
    }
}
