package baseball.game;

import baseball.game.utils.IntegerValidator;
import baseball.game.utils.ScoreBoard;

import java.util.List;

import static baseball.game.config.constants.GameMessage.REQUEST_NUMBER;
import static baseball.game.config.constants.GameMessage.THREE_OUT_GAME_END;

public class Game {

    private Computer computer;
    private User user;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
    }

    public static boolean checkGameOver(ScoreBoard scoreBoard) {
        if (scoreBoard.checkStrikeOut()) {
            System.out.println(THREE_OUT_GAME_END);
            return false;
        }
        return true;
    }

    public void run() {
        boolean token = true;

        while (token) {

            System.out.print(REQUEST_NUMBER);
            List<Integer> presumeNumbers = user.presume();
            IntegerValidator.validatePresume(presumeNumbers);

            ScoreBoard scoreBoard = computer.scoreCheck(presumeNumbers);
            scoreBoard.printBallAndStrike();

            token = checkGameOver(scoreBoard);
        }
    }
}
