package baseball.game;

import baseball.ball.Balls;
import util.Input;
import util.Print;

import java.util.List;

public class Game {
    public GameStatus play(List<Integer> random3Numbers) {
        Balls computer = new Balls(random3Numbers);
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
