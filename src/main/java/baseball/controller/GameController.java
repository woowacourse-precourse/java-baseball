package baseball.controller;

import baseball.service.NumericalComparison;
import baseball.service.Result;
import baseball.service.UserInput;
import baseball.utils.GameConsole;
import baseball.utils.GameRandom;

import java.util.List;
import java.util.Map;

import static baseball.enums.Message.*;

public class GameController {
    private static final GameConsole CONSOLE = GameConsole.getInstance();
    private static final GameRandom RANDOM = GameRandom.getInstance();
    private static final UserInput USER_INPUT = UserInput.getInstance();
    private static final NumericalComparison COMPARISON = NumericalComparison.getInstance();
    private static final Result RESULT = Result.getInstance();
    private static String gameStatus = STAND_BY.status();
    private static final boolean CORRECT = true;
    private static final String ENTER = "\r\n";

    public GameController() {
    }

    public void startGame() {
        CONSOLE.println(GAME_START.message());
        List<Integer> computerNumbers = RANDOM.makeNumbers();

        gameStatus = ONGOING.status();
        while (!gameStatus.equals(STOP.status())) {
            if (gameStatus.equals(RESTART.status())) {
                gameStatus = ONGOING.status();
                computerNumbers = RANDOM.makeNumbers();
            }

            List<Integer> userNumbers = USER_INPUT.enterNumbers(ENTER_NUMBER.message());

            Map<String, Integer> score = COMPARISON.compareList(computerNumbers, userNumbers);
            if (RESULT.analysis(score) == CORRECT) {
                gameManager();
            }
        }
    }

    private void gameManager() {
        CONSOLE.println(CORRECT_ANSWER.message() + ENTER + RESTART_OR_STOP.message());
        gameStatus = USER_INPUT.restartOrStop();
    }
}
