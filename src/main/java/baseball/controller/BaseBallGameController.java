package baseball.controller;

import baseball.service.BaseBallGame;
import baseball.view.PlayerNumberInput;
import baseball.view.PrintGuideMessage;
import baseball.view.ReplayNumberInput;

public class BaseBallGameController {
    private final BaseBallGame baseBallGame;

    public BaseBallGameController(BaseBallGame baseBallGame) {
        this.baseBallGame = baseBallGame;
    }

    public void startGame() {
        PrintGuideMessage.printStartMessage();
        baseBallGame.createComputerNumber();
        playGame();
        PrintGuideMessage.printWinMessage();
        checkReplay();
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
        String input = playerNumberInput.inputPlayerNumber();
        baseBallGame.createPlayerNumber(input);
    }

    public void checkReplay() {
        if (getReplayNumberInput()) {
            startGame();
        }
    }

    public boolean getReplayNumberInput() {
        PrintGuideMessage.printRestartMessage();
        ReplayNumberInput replayNumberInput = new ReplayNumberInput();
        String input = replayNumberInput.inputReplayNumber();
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
