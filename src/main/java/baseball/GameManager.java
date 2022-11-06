package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.SystemMsgPrinter.*;

public class GameManager {
    private final InputHandler inputStream = new InputHandler();
    private final OutputHandler outputStream = new OutputHandler();
    private final BaseballManager baseballManager = new BaseballManager();

    public void run() {
        startFirstGame();
        startRepeatedGame();
    }

    private void startFirstGame() {
        printGameStartMessage();
        startLoop();
    }

    private void startRepeatedGame() {
        int flag = Integer.parseInt(Console.readLine());
        if (flag == SystemConstant.GAME_EXIT_CODE) {
            return;
        }
        baseballManager.initComputerNumber();
        startLoop();
        startRepeatedGame();
    }

    private void startLoop() {
        List<Integer> userScore;
        do {
            printGameInputMessage();
            int userInput = inputStream.readIntWithVerification();
            baseballManager.addUserBaseballNumInfo(new BaseballNumber(userInput));
            baseballManager.computeUserScore();
            userScore = baseballManager.getUserScore();
            outputStream.printMessageForData(userScore);
        } while (!isGameOver(userScore));
        printGameEndAndRestartMessage();
    }

    private boolean isGameOver(List<Integer> userScore) {
        return userScore.get(1) == SystemConstant.GAME_DIGIT;
    }
}
