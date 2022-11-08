package baseball.controller;

import baseball.domain.GameResult;
import baseball.output.GameOutput;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    private final GameService gameService;
    private boolean flag;
    private List<Integer> answerNumbers;

    public GameController() {
        this.gameService = new GameService();
    }

    public void gameStart() {
        flag = true;
        do {
            startGameProcess();
            gameProcess();
        } while (flag);
        GameOutput.finishMessageOutput();
    }

    private void startGameProcess() {
        GameOutput.startMessageOutput();
        answerNumbers = gameService.makeRandomNumbers();
    }

    private void gameProcess() {
        while (true) {
            GameOutput.inputUserNumberMessageOutput();
            String input = gameService.validateUserInput(Console.readLine());
            GameResult gameResult = gameService.makeGameResult(input, answerNumbers);

            if (gameResult.isClear()) {
                GameOutput.gameClearMessageOutput();
                GameOutput.restartQuestionMessageOutput();
                flag = gameService.isRetryGame(Console.readLine());
                break;
            } else {
                GameOutput.gameResultOutput(gameResult);
            }
        }
    }
}
