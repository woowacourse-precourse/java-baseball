package baseball.game;

import baseball.ball.Balls;
import util.Input;
import util.Output;
import util.RandomUniqueNumber;

import java.util.List;

public class Game {
    public static final int BALL_SIZE = 3;
    public GameStatus gameStatus;

    public Game() {
        this.gameStatus = GameStatus.PROGRESSING;
    }

    public void play() {
        while (gameStatus.isProgressing()) {
            List<Integer> randomUniqueNumbers = RandomUniqueNumber.getRandomUniqueNumbers(BALL_SIZE);
            gameStatus = play(randomUniqueNumbers);
        }
    }

    public GameStatus play(List<Integer> randomUniqueNumbers) {
        Balls computer = new Balls(randomUniqueNumbers);
        Output.printStart();

        while (true) {
            Output.printWaitForInput();
            List<Integer> playerNumbers = Input.makeListFromInput();
            Balls player = new Balls(playerNumbers);

            GameResult gameResult = computer.compare(player);
            Output.printScore(gameResult);

            if (gameResult.isWinCondition()) {
                Output.printGameOver();
                return Input.readLineAfterGame();
            }
        }
    }
}
