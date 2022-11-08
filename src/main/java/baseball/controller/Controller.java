package baseball.controller;

import baseball.model.GameJudge;
import baseball.model.InputNumber;
import baseball.model.GameMessage;
import baseball.model.RandomNumber;
import baseball.view.GameResult;

import java.util.List;

public class Controller {
    private static boolean isGameOver;

    public static void runBaseballGame() {
        isGameOver = false;
        GameMessage.printGameStartMessage();
        while (!isGameOver) {
            playOneGame();
            askRestartGame();
        }
    }

    private static void playOneGame() {
        List<Integer> computer = RandomNumber.setRandomNumber();
        while (!isGameOver) {
            GameMessage.printInputNumberMessage();
            List<Integer> player = InputNumber.getValidNumberList();

            String result = GameJudge.judgeGameResult(player, computer);
            GameResult.printGameResultMessage(result);

            if (GameJudge.allStrike) {
                GameMessage.printGameOverMessage();
                break;
            }
        }
    }

    private static void askRestartGame() {
        final String RESTART_CHOICE = "1";
        final String END_CHOICE = "2";

        GameMessage.printRestartGameQuestionMessage();
        String restartGameInput = InputNumber.getValidChoice();

        if (restartGameInput.equals(RESTART_CHOICE)) {
            isGameOver = false;
        }
        if (restartGameInput.equals(END_CHOICE)) {
            isGameOver = true;
        }
    }
}