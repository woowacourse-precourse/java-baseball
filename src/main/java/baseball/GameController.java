package baseball;

public class GameController {
    OutputView outputView;
    Game game;

    GameController() {
        game = new Game();
        outputView = new OutputView();
    }

    void gameStart() {
        outputView.printStart();
        do {
            keepGame();
        } while ((game.gameOngoing()));
    }

    void keepGame() {
        outputView.printInput();
        game.inputGameData();
        game.checkStrikeAndBall();
        outputView.printResult(game.getStrike(), game.getBall());
    }

    boolean endProgram() {
        outputView.printKeepGame();
        game.inputEndProgramData();
        if (!game.keepProgram) {
            outputView.printEndProgram();
        }
        return game.keepProgram;
    }
}
