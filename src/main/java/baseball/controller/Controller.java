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
            try {
                playOneGame();
                askRestartGame();
            } catch (IllegalArgumentException error) {
                System.out.println("message: " + error.getMessage());
                isGameOver = true;
                throw error;
            }
        }
    }

    private static void playOneGame() {
        List<Integer> computer = RandomNumber.setRandomNumber();
        System.out.println("컴퓨터: " + computer);
        while (!isGameOver) {
            GameMessage.printInputNumberMessage();
            List<Integer> player = InputNumber.getValidNumberList();
            //System.out.println("플레이어: " + player);

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
        //System.out.println("restart?" + restartGameInput);

        if (restartGameInput.equals(RESTART_CHOICE)) {
            isGameOver = false;
        }
        if (restartGameInput.equals(END_CHOICE)) {
            isGameOver = true;
        }
    }
}