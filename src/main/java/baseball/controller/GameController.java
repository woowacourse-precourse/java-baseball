package baseball.controller;

import baseball.service.NumericalComparison;
import baseball.service.Result;
import baseball.service.UserInput;
import baseball.utils.ConsoleLog;
import baseball.utils.MakeRandom;

import java.util.List;
import java.util.Map;

import static baseball.enums.Message.*;

public class GameController {
    private static final ConsoleLog consoleLog = ConsoleLog.getInstance();
    private static final MakeRandom makeRandom = MakeRandom.getInstance();
    private static final UserInput userInput = UserInput.getInstance();
    private static final NumericalComparison numericalComparison = NumericalComparison.getInstance();
    private static final Result result = Result.getInstance();
    private static String gameStatus = STAND_BY.status();
    private static final boolean CORRECT = true;
    public GameController() {
    }

    public void startGame() {
        consoleLog.println(GAME_START.message());
        List<Integer> computerNumbers = makeRandom.numbers();

        gameStatus = ONGOING.status();
        while (!gameStatus.equals(STOP.status())) {
            if (gameStatus.equals(RESTART.status())) {
                gameStatus = ONGOING.status();
                computerNumbers = makeRandom.numbers();
            }

            List<Integer> userNumbers = userInput.numbers(ENTER_NUMBER.message());

            Map<String, Integer> score = numericalComparison.compareList(computerNumbers, userNumbers);
            if (result.analysis(score) == CORRECT) {
                gameManager();
            }
        }
    }

    private void gameManager() {
        consoleLog.println(String.format("%s\r\n%s", CORRECT_ANSWER.message(), RESTART_OR_STOP.message()));
        gameStatus = userInput.restartOrStop();
    }
}
