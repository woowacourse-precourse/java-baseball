package baseball.controller;

import baseball.service.GameStartService;
import baseball.status.ControlNumberStatus;
import baseball.status.HintStatus;
import baseball.view.View;
public class GameStartController {
    private static void controlGame() {
        View.printRestartOrStop();

        String userInput = GameStartService.getUserInput();

        if (userInput.equals(ControlNumberStatus.START_NUMBER.getText())) {
            GameStartService.initGame();
            startGame();
        } else if (userInput.equals(ControlNumberStatus.END_NUMBER.getText())) {
            finishGame();
        } else {
            throw new IllegalArgumentException("입력값이 1 또는 2가 아닙니다.");
        }
    }

    private static void finishGame() {
        View.printFinishGame();
    }

    public static void startFirstGame() {
        View.printStartGame();
        startGame();
    }

    private static void startGame() {
        GameStartService.initBallAndStrike();
        View.printInputUserNumber();
        saveNumber();
        compareNumber();
    }

    private static void compareNumber() {
        String hint = GameStartService.compareNumber();
        showHint(hint);
    }

    private static void showHint(String hint) {
        View.printHint(hint);

        if (hint.equals(HintStatus.ANSWER.getText())) {
            View.printCompleteGame();
            controlGame();
        } else {
            startGame();
        }
    }

    private static void saveNumber() {
        saveComputerNumber();
        saveUserNumber();
    }

    private static void saveUserNumber() {
        GameStartService.saveUserNumber();
    }

    private static void saveComputerNumber() {
        GameStartService.saveComputerNumber();
    }
}


