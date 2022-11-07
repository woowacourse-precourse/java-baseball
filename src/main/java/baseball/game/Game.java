package baseball.game;

import baseball.ball.Balls;
import util.Input;
import util.Print;
import util.RandomUniqueNumber;

import java.util.List;

public class Game {
    public void play() {
        GameStatus gameStatus = GameStatus.PROGRESSING;

        while (gameStatus.isProgressing()) {
            gameStatus = play(RandomNumber.getRandom3Numbers());
            List<Integer> randomUniqueNumbers = RandomUniqueNumber.getRandomUniqueNumbers(BALL_SIZE);
            gameStatus = play(randomUniqueNumbers);
        }
    }

    public GameStatus play(List<Integer> randomUniqueNumbers) {
        Balls computer = new Balls(randomUniqueNumbers);
        Print.printStart();

        while (true) {
            Print.printWaitForInput();
            List<Integer> playerNumbers = Input.makeListFromInput();
            Balls player = new Balls(playerNumbers);

            GameResult gameResult = computer.compare(player);
            Print.printScore(gameResult);

            if (gameResult.isWinCondition()) {
                Print.printGameOver();
                return Input.readLineAfterGame();
            }
        }
    }
}
