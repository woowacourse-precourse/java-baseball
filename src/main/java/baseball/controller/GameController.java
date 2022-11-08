package baseball.controller;

import baseball.model.ContinueGame;
import baseball.view.Display;
import baseball.view.UserInput;


public class GameController {
    private static final ContinueGame continueGame = ContinueGame.getInstance();
    private static final Display display = Display.getInstance();
    private static final UserInput userInput = UserInput.getInstance();

    private final BaseballGame baseballGame;

    public GameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public static GameController from(BaseballGame baseballGame) {
        return new GameController(baseballGame);
    }

    public void startGame() {
        display.printStartGame();

        do {
            playBaseballGame();
        } while (selectContinueGame());
    }

    private void playBaseballGame() {
        baseballGame.playBaseballGame();
    }

    private boolean selectContinueGame() {
        String inputSelectToContinueGame = askSelectContinueGame();
        boolean isContinueGame = continueGame.selectContinueGame(inputSelectToContinueGame);
        return isContinueGame;
    }

    private String askSelectContinueGame() {
        display.printContinueGame();

        String inputToSelectContinueGame = userInput.input();
        return inputToSelectContinueGame;
    }
}
