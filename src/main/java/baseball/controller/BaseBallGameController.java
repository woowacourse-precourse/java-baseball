package baseball.controller;

import baseball.service.BaseBallGame;
import baseball.view.input.PlayerNumberInput;
import baseball.view.print.PrintGuideMessage;
import baseball.view.input.RestartNumberInput;

public class BaseBallGameController {
    private static final String RESTART = "1";
    private final BaseBallGame baseBallGame;

    public BaseBallGameController(BaseBallGame baseBallGame) {
        this.baseBallGame = baseBallGame;
    }

    public void startGame() {
        PrintGuideMessage.printStartMessage();
        baseBallGame.createComputerNumber();
        playGame();
        PrintGuideMessage.printWinMessage();
        checkRestart();
    }

    public void playGame() {
        getPlayerNumberInput();
        baseBallGame.getHint();
        if (!baseBallGame.endGame()) {
            playGame();
        }
    }

    public void getPlayerNumberInput() {
        PrintGuideMessage.printInputMessage();
        PlayerNumberInput playerNumberInput = new PlayerNumberInput();
        String input = playerNumberInput.inputNumber();
        baseBallGame.createPlayerNumber(input);
    }

    public void checkRestart() {
        if (getRestartNumberInput()) {
            startGame();
        }
    }

    public boolean getRestartNumberInput() {
        PrintGuideMessage.printRestartMessage();
        RestartNumberInput restartNumberInput = new RestartNumberInput();
        String input = restartNumberInput.inputNumber();
        if (input.equals(RESTART)) {
            return true;
        }
        return false;
    }
}